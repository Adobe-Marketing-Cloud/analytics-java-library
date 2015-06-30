package com.adobe.analytics.client.auth;

import java.net.Proxy;

public class AuthenticatorBuilder {

	public enum AuthType {
		WSSE, JWTO_OAUTH, CREDENTIALS_OAUTH
	}

	private String clientId;

	private String username;

	private String secret;

	private byte[] privateKey;

	private String endpoint;

	private AuthType type;

	private Proxy proxy;

	public AuthenticatorBuilder setType(AuthType type) {
		this.type = type;
		return this;
	}

	public AuthenticatorBuilder setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public AuthenticatorBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public AuthenticatorBuilder setSecret(String secret) {
		this.secret = secret;
		return this;
	}

	public AuthenticatorBuilder setPrivateKey(byte[] privateKey) {
		this.privateKey = privateKey;
		return this;
	}

	public AuthenticatorBuilder setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	public AuthenticatorBuilder setProxy(Proxy proxy) {
		this.proxy = proxy;
		return this;
	}

	public ClientAuthenticator build() {
		switch (type) {
			case CREDENTIALS_OAUTH:
				return new ClientCredentialsOAuthenticator(clientId, secret, endpoint, proxy);

			case JWTO_OAUTH:
				return new JWTOAuthenticator(privateKey, clientId, username, endpoint, proxy);

			case WSSE:
				return new WsseAuthenticator(username, secret);
		}
		throw new IllegalStateException("Authentication type hasn't been chosen: " + type);
	}
}
