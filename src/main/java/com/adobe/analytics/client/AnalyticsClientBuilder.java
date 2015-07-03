package com.adobe.analytics.client;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import com.adobe.analytics.client.auth.AuthenticatorBuilder;
import com.adobe.analytics.client.auth.AuthenticatorBuilder.AuthType;

public class AnalyticsClientBuilder {

	private AuthenticatorBuilder authBuild;

	private String endpoint;

	private Proxy proxy;

	public AnalyticsClientBuilder() {
		authBuild = new AuthenticatorBuilder();
	}

	public AnalyticsClientBuilder setEndpoint(String endpoint) {
		if (endpoint == null) {
			throw new NullPointerException("Endpoint can't be null");
		}
		authBuild.setEndpoint(endpoint);
		this.endpoint = endpoint;
		return this;
	}

	public AnalyticsClientBuilder authenticateWithSecret(String username, String secret) {
		authBuild.setUsername(username);
		authBuild.setSecret(secret);
		authBuild.setType(AuthType.WSSE);
		return this;
	}

	public AnalyticsClientBuilder authenticateWithJWTOAuth(Path privateKeyPath, String clientId,
			String username) throws IOException {
		authBuild.setPrivateKey(Files.readAllBytes(privateKeyPath));
		authBuild.setClientId(clientId);
		authBuild.setUsername(username);
		authBuild.setType(AuthType.JWTO_OAUTH);
		return this;
	}

	public AnalyticsClientBuilder authenticateWithJWTOAuth(byte[] privateKey, String clientId, String username) {
		authBuild.setPrivateKey(privateKey);
		authBuild.setClientId(clientId);
		authBuild.setUsername(username);
		authBuild.setType(AuthType.JWTO_OAUTH);
		return this;
	}

	public AnalyticsClientBuilder authenticateWithClientCredentialsOAuth(String clientId, String secret) {
		authBuild.setClientId(clientId);
		authBuild.setSecret(secret);
		authBuild.setType(AuthType.CREDENTIALS_OAUTH);
		return this;
	}

	public AnalyticsClientBuilder withProxy(String hostname, int port) {
		this.proxy = new Proxy(Type.HTTP, new InetSocketAddress(hostname, port));
		authBuild.setProxy(proxy);
		return this;
	}

	public AnalyticsClientBuilder withProxy(final String hostname, final int port, final String username, final String password) {
		withProxy(hostname, port);
		final Authenticator authenticator = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return (new PasswordAuthentication(username, password.toCharArray()));
			}
		};
		Authenticator.setDefault(authenticator);
		return this;
	}

	public AnalyticsClient build() {
		if (endpoint == null) {
			throw new IllegalStateException("Endpoint hasn't been set");
		}
		return new AnalyticsClient(authBuild.build(), endpoint, proxy);
	}
}
