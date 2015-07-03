package com.adobe.analytics.client;

import com.adobe.analytics.client.auth.ClientAuthenticator;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import static com.adobe.analytics.client.JsonUtil.GSON;

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
