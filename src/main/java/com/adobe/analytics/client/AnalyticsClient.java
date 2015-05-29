package com.adobe.analytics.client;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.IOUtils;

import com.adobe.analytics.client.auth.ClientAuthenticator;
import com.adobe.analytics.client.auth.OAuthenticator;
import com.adobe.analytics.client.auth.WsseAuthenticator;

import static com.adobe.analytics.client.JsonUtil.GSON;

public class AnalyticsClient {

	private final ClientAuthenticator authenticator;

	private final String endpoint;

	public static AnalyticsClient authenticateWithSecret(String username, String secret, String endpoint) {
		final ClientAuthenticator auth = new WsseAuthenticator(username, secret);
		return new AnalyticsClient(auth, endpoint);
	}

	public static AnalyticsClient authenticateWithOAuth(Path privateKeyPath, String clientId,
			String username, String endpoint) throws IOException {
		return authenticateWithOAuth(Files.readAllBytes(privateKeyPath), clientId, username, endpoint);
	}

	public static AnalyticsClient authenticateWithOAuth(byte[] privateKey, String clientId, String username,
			String endpoint) {
		final ClientAuthenticator auth = new OAuthenticator(privateKey, clientId, username, endpoint);
		return new AnalyticsClient(auth, endpoint);
	}

	private AnalyticsClient(ClientAuthenticator authenticator, String endpoint) {
		this.authenticator = authenticator;
		this.endpoint = endpoint;
	}

	public <T> T callMethod(String method, Object data, Type resultType) throws IOException {
		final String request = GSON.toJson(data);
		final String response = callMethod(method, request);
		return GSON.fromJson(response, resultType);
	}

	public String callMethod(String method, String data) throws IOException {
		final URL url = new URL(String.format("https://%s/admin/1.4/rest/?method=%s", endpoint, method));
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		authenticator.authenticate(connection);
		connection.setDoOutput(true);

		IOUtils.write(data, connection.getOutputStream());
		return ConnectionUtil.readResponse(connection);
	}
}
