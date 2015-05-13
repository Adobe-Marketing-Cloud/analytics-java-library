package com.adobe.analytics.client.methods;

import java.io.IOException;
import java.lang.reflect.Type;

import com.adobe.analytics.client.AnalyticsClient;
import com.adobe.analytics.client.domain.AddLogin;
import com.google.gson.reflect.TypeToken;

public class PermissionsMethods {

	private final AnalyticsClient client;

	public PermissionsMethods(AnalyticsClient client) {
		this.client = client;
	}

	public boolean addLogin(AddLogin request) throws IOException {
		Type type = new TypeToken<Integer>() {}.getType();
		return Integer.valueOf(1).equals(client.callMethod("Permissions.AddLogin", request, type));
	}
}
