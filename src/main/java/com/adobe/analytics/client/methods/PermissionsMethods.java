package com.adobe.analytics.client.methods;

import static com.adobe.analytics.client.JsonUtil.GSON;

import java.io.IOException;

import com.adobe.analytics.client.AnalyticsClient;
import com.adobe.analytics.client.domain.AddLogin;

public class PermissionsMethods {

	private final AnalyticsClient client;

	public PermissionsMethods(AnalyticsClient client) {
		this.client = client;
	}

	public boolean addLogin(AddLogin request) throws IOException {
		final String serializedRequest = GSON.toJson(request);
		final String response = client.callMethod("Permissions.AddLogin", serializedRequest);
		return "true".equals(response);
	}
}
