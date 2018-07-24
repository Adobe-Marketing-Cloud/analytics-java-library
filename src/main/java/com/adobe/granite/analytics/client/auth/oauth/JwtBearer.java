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

package com.adobe.granite.analytics.client.auth.oauth;

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
