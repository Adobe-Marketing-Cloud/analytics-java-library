package com.adobe.granite.analytics.client.methods;

import static com.adobe.granite.analytics.client.JsonUtil.o;

import java.io.IOException;

import com.adobe.granite.analytics.client.AnalyticsClient;
import com.adobe.granite.analytics.client.domain.ReportDescription;
import com.adobe.granite.analytics.client.domain.ReportResponse;
import com.google.gson.JsonObject;

public class ReportMethods {

	private final AnalyticsClient client;

	public ReportMethods(AnalyticsClient client) {
		this.client = client;
	}

	public int queue(ReportDescription reportDesc) throws IOException {
		final JsonObject response = client.callMethod("Report.Queue", o("reportDescription", reportDesc),
				JsonObject.class);
		return response.get("reportID").getAsInt();
	}

	public ReportResponse get(int reportId) throws IOException {
		return client.callMethod("Report.Get", o("reportID", reportId), ReportResponse.class);
	}
}
