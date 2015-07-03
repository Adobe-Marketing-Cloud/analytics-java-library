package com.adobe.analytics.client.auth.oauth;

import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtBearer implements GrantType {

	private final byte[] privateKey;

	private final String clientId;

	private final String username;

	private final String endpoint;

	public JwtBearer(byte[] privateKey, String clientId, String username, String endpoint) {
		this.privateKey = privateKey;
		this.clientId = clientId;
		this.username = username;
		this.endpoint = endpoint;
	}

	@Override
	public Map<String, String> getParameters() {
		final Map<String, String> params = new LinkedHashMap<>();
		params.put("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
		params.put("client_id", clientId);
		params.put("assertion", getAssertion());
		return params;
	}

	private String getAssertion() {
		return Jwts.builder().setIssuer(clientId).setSubject(username).setAudience(endpoint)
				.signWith(SignatureAlgorithm.HS256, privateKey).compact();
	}

	@Override
	public void processRequest(HttpURLConnection conn) {
	}

}
