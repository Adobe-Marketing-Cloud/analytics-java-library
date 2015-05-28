package com.adobe.analytics.client.auth;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class WsseAuthenticator implements ClientAuthenticator {

	private final String username;

	private final String secret;

	public WsseAuthenticator(String username, String secret) {
		this.username = username;
		this.secret = secret;
	}

	@Override
	public void authenticate(HttpURLConnection connection) {
		connection.addRequestProperty("X-WSSE", getHeader());
	}

	private String getHeader() {
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
