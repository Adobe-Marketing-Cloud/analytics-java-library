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

package com.adobe.analytics.client.domain;

import java.io.IOException;
import java.lang.reflect.Type;

import com.adobe.granite.analytics.client.AnalyticsClient;
import com.adobe.granite.analytics.client.domain.ReportDescription;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import static com.adobe.granite.analytics.client.JsonUtil.o;

public class Bookmark {

	@SerializedName("rsid")
	private String rsid;

	public String getRsid() {
		return rsid;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	@SerializedName("name")
	private String name;
	
	@SerializedName("id")
	private long id;

	private AnalyticsClient client;

	public void setClient(AnalyticsClient client) {
		this.client = client;
	}
	
	public ReportDescription getReportDescription() throws IOException {
		final Type type = new TypeToken<ReportDescriptionResponse>() {}.getType();
		ReportDescriptionResponse rdr = client.callMethod("Bookmark.GetReportDescription", o("bookmark_id", this.id), type);
		return rdr.getReportDescription();
	}

}
