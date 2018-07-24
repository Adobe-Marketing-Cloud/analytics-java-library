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
