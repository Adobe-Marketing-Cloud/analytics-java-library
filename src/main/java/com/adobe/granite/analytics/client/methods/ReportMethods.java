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
