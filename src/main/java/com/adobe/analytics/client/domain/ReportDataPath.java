package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public class ReportDataPath {

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
