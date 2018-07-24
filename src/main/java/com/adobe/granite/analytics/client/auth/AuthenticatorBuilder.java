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

import java.net.Proxy;

import com.adobe.granite.analytics.client.auth.oauth.ClientCredentials;
import com.adobe.granite.analytics.client.auth.oauth.JwtBearer;

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
		if (type == null) {
			throw new NullPointerException("Authentication type can't be null");
		}
		this.type = type;
		return this;
	}

	public AuthenticatorBuilder setClientId(String clientId) {
		if (clientId == null) {
			throw new NullPointerException("ClientId can't be null");
		}
		this.clientId = clientId;
		return this;
	}

	public AuthenticatorBuilder setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("Username can't be null");
		}
		this.username = username;
		return this;
	}

	public AuthenticatorBuilder setSecret(String secret) {
		if (secret == null) {
			throw new NullPointerException("Secret can't be null");
		}
		this.secret = secret;
		return this;
	}

	public AuthenticatorBuilder setPrivateKey(byte[] privateKey) {
		if (privateKey == null) {
			throw new NullPointerException("Private key can't be null");
		}
		this.privateKey = privateKey;
		return this;
	}

	public AuthenticatorBuilder setEndpoint(String endpoint) {
		if (endpoint == null) {
			throw new NullPointerException("Endpoint can't be null");
		}
		this.endpoint = endpoint;
		return this;
	}

	public AuthenticatorBuilder setProxy(Proxy proxy) {
		if (proxy == null) {
			throw new NullPointerException("Proxy can't be null");
		}
		this.proxy = proxy;
		return this;
	}

	public ClientAuthenticator build() {
		switch (type) {
		case CREDENTIALS_OAUTH:
			return new OAuthenticator(new ClientCredentials(clientId, secret), endpoint, proxy);

		case JWTO_OAUTH:
			return new OAuthenticator(new JwtBearer(privateKey, clientId, username, endpoint), endpoint, proxy);

		case WSSE:
			return new WsseAuthenticator(username, secret);

		default:
			break;
		}
		throw new IllegalStateException("Authentication type hasn't been chosen: " + type);
	}
}
