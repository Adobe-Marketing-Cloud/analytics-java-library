package com.adobe.analytics.client;

import com.adobe.analytics.client.auth.ClientAuthenticator;
import com.adobe.analytics.client.auth.ClientCredentialsOAuthenticator;
import com.adobe.analytics.client.auth.JWTOAuthenticator;
import com.adobe.analytics.client.auth.WsseAuthenticator;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.adobe.analytics.client.JsonUtil.GSON;

public class AnalyticsClient {

	private final Proxy proxy;

	private final ClientAuthenticator authenticator;

	private final String endpoint;

	public static AnalyticsClient authenticateWithSecret(String username, String secret, String endpoint) {
		final ClientAuthenticator auth = new WsseAuthenticator(username, secret);
		return new AnalyticsClient(auth, endpoint);
	}

	public static AnalyticsClient authenticateWithJWTOAuth(Path privateKeyPath, String clientId,
														   String username, String endpoint) throws IOException {
		return authenticateWithJWTOAuth(Files.readAllBytes(privateKeyPath), clientId, username, endpoint);
	}

	public static AnalyticsClient authenticateWithJWTOAuth(byte[] privateKey, String clientId, String username,
														   String endpoint) {
		final ClientAuthenticator auth = new JWTOAuthenticator(privateKey, clientId, username, endpoint);
		return new AnalyticsClient(auth, endpoint);
	}

	public static AnalyticsClient authenticateWithClientCredentialsOAuth(String clientId, String clientSecret,
																		 String endpoint) {
		final ClientAuthenticator auth = new ClientCredentialsOAuthenticator(clientId, clientSecret);
		return new AnalyticsClient(auth, endpoint);
	}

	private AnalyticsClient(ClientAuthenticator authenticator, String endpoint) {
		this(authenticator, endpoint, null);
	}
	
	private AnalyticsClient(ClientAuthenticator authenticator, String endpoint, Proxy proxy) {
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

	public AnalyticsClient withProxy(String hostname, int port) {
		final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port));
		return new AnalyticsClient(authenticator, hostname, proxy);
	}
}
