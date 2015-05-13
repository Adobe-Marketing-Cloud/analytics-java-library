package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public enum ReportDescriptionSource {

	@SerializedName("standard")
	STANDARD(),

	@SerializedName("realtime")
	REALTIME();
}
