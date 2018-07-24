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

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import com.adobe.granite.analytics.client.auth.AuthenticatorBuilder;
import com.adobe.granite.analytics.client.auth.AuthenticatorBuilder.AuthType;

public class AnalyticsClientBuilder {

	private final AuthenticatorBuilder authBuild;

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
				return new PasswordAuthentication(username, password.toCharArray());
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
