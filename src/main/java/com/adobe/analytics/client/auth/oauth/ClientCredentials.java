package com.adobe.analytics.client.auth.oauth;

import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class ClientCredentials implements GrantType {

	private final String clientId;

	private final String clientSecret;

	public ClientCredentials(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	@Override
	public Map<String, String> getParameters() {
		return Collections.singletonMap("grant_type", "client_credentials");
	}

	@Override
	public void processRequest(HttpURLConnection conn) {
		conn.setRequestProperty("Authorization", getAuthHeader());
	}

	private String getAuthHeader() {
		String auth = this.clientId + ":" + this.clientSecret;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(encodedAuth);
	}
}
