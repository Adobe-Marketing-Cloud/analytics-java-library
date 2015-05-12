package com.adobe.analytics.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import static com.adobe.analytics.client.JsonUtil.GSON;

public class AnalyticsClient {

	private final String username;

	private final String secret;

	private final String endpoint;

	public AnalyticsClient(final String username, final String secret, final String endpoint) {
		this.username = username;
		this.secret = secret;
		this.endpoint = endpoint;
	}

	public <T> T callMethod(String method, Object data, Type resultType) throws IOException {
		return GSON.fromJson(callMethod(method, GSON.toJson(data)), resultType);
	}

	public String callMethod(String method, String data) throws IOException {
		final URL url = new URL(String.format("https://%s/admin/1.4/rest/?method=%s", endpoint, method));
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("X-WSSE", getHeader());
		connection.setDoOutput(true);

		IOUtils.write(data, connection.getOutputStream());

		final int status = connection.getResponseCode();
		if (status < 200 || status > 299) {
			final InputStream errorStream = connection.getErrorStream();
			if (errorStream != null) {
				final String errorMessage = IOUtils.toString(errorStream);
				try {
					final JsonObject jsonResult = GSON.fromJson(errorMessage, JsonObject.class);
					throw new ApiException(jsonResult);
				} catch (JsonSyntaxException e) {
					// it's not a valid JSON, we'll throw an IOException below
				}
			}
			throw new IOException(String.format("HTTP error %d %s", connection.getResponseCode(),
					connection.getResponseMessage()));
		} else {
			return IOUtils.toString(connection.getInputStream());
		}
	}

	private String getHeader() throws UnsupportedEncodingException {
		final String nonce = UUID.randomUUID().toString();
		final String created = currentDate();
		final String passwordDigest = getBase64Digest(nonce, created, secret);
		final StringBuilder builder = new StringBuilder("UsernameToken ");
		addField(builder, "Username", username).append(", ");
		addField(builder, "PasswordDigest", passwordDigest).append(", ");
		addField(builder, "Nonce", Base64.encodeBase64String(nonce.getBytes())).append(", ");
		addField(builder, "Created", created);
		return builder.toString();
	}

	private static StringBuilder addField(StringBuilder builder, String fieldName, String fieldValue) {
		builder.append(fieldName).append("=\"").append(fieldValue).append('"');
		return builder;
	}

	private static String currentDate() {
		final TimeZone tz = TimeZone.getTimeZone("UTC");
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		df.setTimeZone(tz);
		return df.format(new Date());
	}

	private static String getBase64Digest(String... strings) {
		final MessageDigest digest = DigestUtils.getSha1Digest();
		digest.reset();
		for (final String s : strings) {
			DigestUtils.updateDigest(digest, s);
		}
		return Base64.encodeBase64String(digest.digest());
	}

}
