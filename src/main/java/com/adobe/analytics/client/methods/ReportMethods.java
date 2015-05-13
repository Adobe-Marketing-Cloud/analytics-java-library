package com.adobe.analytics.client.methods;

import java.io.IOException;

import com.adobe.analytics.client.AnalyticsClient;
import com.adobe.analytics.client.domain.ReportDescription;
import com.adobe.analytics.client.domain.ReportResponse;

public class ReportMethods {

	private final AnalyticsClient client;

	public ReportMethods(AnalyticsClient client) {
		this.client = client;
	}

	public int queue(ReportDescription reportDesc) throws IOException {
		return client.callMethod("Report.Queue", reportDesc, Integer.class);
	}

	public ReportResponse get(int reportId) throws IOException {
		return client.callMethod("Report.Get", reportId, ReportResponse.class);
	}
}
