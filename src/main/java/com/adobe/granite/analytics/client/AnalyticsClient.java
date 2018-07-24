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

package com.adobe.granite.analytics.client;

import com.adobe.granite.analytics.client.auth.ClientAuthenticator;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import static com.adobe.granite.analytics.client.JsonUtil.GSON;

public class AnalyticsClient {

	private final Proxy proxy;

	private final ClientAuthenticator authenticator;

	private final String endpoint;

	AnalyticsClient(ClientAuthenticator authenticator, String endpoint, Proxy proxy) {
		this.authenticator = authenticator;
		this.endpoint = endpoint;
		this.proxy = proxy;
	}

	public <T> T callMethod(String method, Object data, Type resultType) throws IOException {
		final String request = GSON.toJson(data);
		final String response = callMethod(method, request);
		return GSON.fromJson(response, resultType);
	}

	public String callMethod(String method, String data) throws IOException {
		final URL url = new URL(String.format("https://%s/admin/1.4/rest/?method=%s", endpoint, method));
		final HttpURLConnection connection;
		if (proxy == null) {
			connection = (HttpURLConnection) url.openConnection();
		} else {
			connection = (HttpURLConnection) url.openConnection(proxy);
		}
		authenticator.authenticate(connection);
		connection.setDoOutput(true);

		IOUtils.write(data, connection.getOutputStream());
		return ConnectionUtil.readResponse(connection);
	}
}
