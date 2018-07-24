/*
Copyright 2018 Adobe. All rights reserved.
This file is licensed to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy
of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
OF ANY KIND, either express or implied. See the License for the specific language
governing permissions and limitations under the License.
*/

package com.adobe.granite.analytics.client.auth;

import com.adobe.granite.analytics.client.ConnectionUtil;
import com.adobe.granite.analytics.client.JsonUtil;
import com.adobe.granite.analytics.client.auth.oauth.GrantType;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;

public class OAuthenticator implements ClientAuthenticator {

	private static final String OAUTH_URL = "https://%s/token";

	private final String endpoint;

	private final Proxy proxy;

	private final GrantType grantType;

	private String accessToken;

	private Calendar expires;

	public OAuthenticator(GrantType grantType, String endpoint, Proxy proxy) {
		this.endpoint = endpoint;
		this.proxy = proxy;
		this.grantType = grantType;
	}

	@Override
	public void authenticate(HttpURLConnection connection) throws JsonSyntaxException, IOException {
		if (!isTokenValid()) {
			getToken();
		}
		connection.addRequestProperty("Authorization", String.format("Bearer %s", accessToken));
	}

	private boolean isTokenValid() {
		final Calendar now = Calendar.getInstance();
		return accessToken != null && now.before(expires);
	}

	private void getToken() throws JsonSyntaxException, IOException {
		final URL url = new URL(String.format(OAUTH_URL, endpoint));
		final HttpURLConnection conn;
		if (proxy == null) {
			conn = (HttpURLConnection) url.openConnection();
		} else {
			conn = (HttpURLConnection) url.openConnection(proxy);
		}
		setupPostRequest(conn);
		final JsonObject response = JsonUtil.GSON.fromJson(ConnectionUtil.readResponse(conn), JsonObject.class);
		accessToken = response.get("access_token").getAsString();
		expires = Calendar.getInstance();
		expires.add(Calendar.SECOND, response.get("expires_in").getAsInt());
	}

	private void setupPostRequest(HttpURLConnection conn) throws IOException {
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		grantType.processRequest(conn);
		addPostParams(conn, grantType.getParameters());
	}

	private void addPostParams(HttpURLConnection conn, Map<String, String> parameters) throws IOException {
		StringBuilder result = new StringBuilder();
		boolean first = true;

		for (Entry<String, String> pair : parameters.entrySet()) {
			if (first)
				first = false;
			else
				result.append('&');

			result.append(URLEncoder.encode(pair.getKey(), StandardCharsets.UTF_8.name()));
			result.append('=');
			result.append(URLEncoder.encode(pair.getValue(), StandardCharsets.UTF_8.name()));
		}
		IOUtils.write(result.toString(), conn.getOutputStream());
	}
}
