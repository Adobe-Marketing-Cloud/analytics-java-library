package com.adobe.analytics.client.reportsuite;

import java.io.IOException;

import com.adobe.analytics.client.AnalyticsClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static com.adobe.analytics.client.JsonUtil.*;

public class ReportSuiteSettings {
	public static void main(String[] args) throws IOException {
		final String username = System.getProperty("username");
		final String password = System.getProperty("password");
		final String endpoint = System.getProperty("endpoint");
		final AnalyticsClient client = new AnalyticsClient(username, password, endpoint);

		final JsonElement element = client.callMethod("ReportSuite.GetSettings", m("rsid_list", args),
				JsonElement.class);
		System.out.println(GSON.toJson(element));
	}
}
