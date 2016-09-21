package com.adobe.granite.analytics.client.methods;

import java.io.IOException;

import com.adobe.granite.analytics.client.AnalyticsClient;
import com.adobe.granite.analytics.client.domain.AddLogin;
import com.adobe.granite.analytics.client.JsonUtil;

public class PermissionsMethods {

	private final AnalyticsClient client;

	public PermissionsMethods(AnalyticsClient client) {
		this.client = client;
	}

	public boolean addLogin(AddLogin request) throws IOException {
		final String serializedRequest = JsonUtil.GSON.toJson(request);
		final String response = client.callMethod("Permissions.AddLogin", serializedRequest);
		return "true".equals(response);
	}
}
