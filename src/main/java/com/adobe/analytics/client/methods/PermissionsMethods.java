package com.adobe.analytics.client.methods;

import java.io.IOException;

import com.adobe.analytics.client.AnalyticsClient;
import com.adobe.analytics.client.domain.AddLogin;

public class PermissionsMethods {

	private final AnalyticsClient client;

	public PermissionsMethods(AnalyticsClient client) {
		this.client = client;
	}

	public boolean addLogin(AddLogin request) throws IOException {
		return Integer.valueOf(1).equals(client.callMethod("Permissions.AddLogin", request, Integer.class));
	}
}
