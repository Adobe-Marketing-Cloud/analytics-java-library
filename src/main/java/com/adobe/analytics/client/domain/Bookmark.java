package com.adobe.analytics.client.domain;

import java.io.IOException;
import java.lang.reflect.Type;

import com.adobe.analytics.client.AnalyticsClient;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import static com.adobe.analytics.client.JsonUtil.a;
import static com.adobe.analytics.client.JsonUtil.o;

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
