package com.adobe.analytics.client.auth;

import com.adobe.analytics.client.ConnectionUtil;
import com.adobe.analytics.client.JsonUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClientCredentialsOAuthenticator extends OAuthenticator {
	private static final String OAUTH_URL = "https://api.omniture.com/token";

	private final String clientId;

	private final String clientSecret;

	public ClientCredentialsOAuthenticator(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	@Override
	public void getToken() throws JsonSyntaxException, IOException {
		URL url = new URL(OAUTH_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		setupPostRequest(conn);
		final JsonObject response = JsonUtil.GSON.fromJson(ConnectionUtil.readResponse(conn),
				JsonObject.class);
		getTokenJSONResponse(response);
	}

	private void setupPostRequest(HttpURLConnection conn) throws IOException {
		setDoOutput(conn);
		setRequestMethod(conn);
		setBasicAuth(conn);
		writePostParameter(conn);
	}

	private void setDoOutput(HttpURLConnection conn) {
		conn.setDoOutput(true);
	}

	private void setRequestMethod(HttpURLConnection conn) throws ProtocolException {
		conn.setRequestMethod("POST");
	}

	private void setBasicAuth(HttpURLConnection conn) {
		conn.setRequestProperty("Authorization", getAuthHeader());
	}

	private void writePostParameter(HttpURLConnection connection) throws IOException {
		String urlParameters = "grant_type=client_credentials";
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		IOUtils.write(postData, connection.getOutputStream());
	}

	private String getAuthHeader() {
		String auth = this.clientId + ":" + this.clientSecret;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(encodedAuth);
	}
}
