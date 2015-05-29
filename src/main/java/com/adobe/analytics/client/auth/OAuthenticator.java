package com.adobe.analytics.client.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import com.adobe.analytics.client.ConnectionUtil;
import com.adobe.analytics.client.JsonUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class OAuthenticator implements ClientAuthenticator {

	private static final String OAUTH_URL = "https://%s/token?grant_type=urn:ietf:params:oauth:grant-type:jwt-bearer&client_id=%s&assertion=%s";

	private final byte[] privateKey;

	private final String clientId;

	private final String username;

	private final String endpoint;

	private String accessToken;

	private Calendar expires;

	public OAuthenticator(byte[] privateKey, String clientId, String username, String endpoint) {
		this.privateKey = privateKey;
		this.clientId = clientId;
		this.username = username;
		this.endpoint = endpoint;
	}

	public void login() throws JsonSyntaxException, IOException {
		final String jwt = Jwts.builder()
				.setIssuer(clientId)
				.setSubject(username)
				.setAudience(endpoint)
				.signWith(SignatureAlgorithm.HS256, privateKey).compact();
		final URL url = new URL(String.format(OAUTH_URL, endpoint, clientId, jwt));
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		final JsonObject response = JsonUtil.GSON.fromJson(ConnectionUtil.readResponse(connection),
				JsonObject.class);
		accessToken = response.get("access_token").getAsString();
		expires = Calendar.getInstance();
		expires.add(Calendar.SECOND, response.get("expires_in").getAsInt());
	}

	@Override
	public void authenticate(HttpURLConnection connection) throws JsonSyntaxException, IOException {
		if (!isTokenValid()) {
			login();
		}
		connection.addRequestProperty("Authorization", String.format("Bearer %s", accessToken));
	}

	private boolean isTokenValid() {
		final Calendar now = Calendar.getInstance();
		return accessToken != null && now.before(expires);
	}
}
