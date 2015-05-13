package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public enum ReportDescriptionDateGranularity {
	@SerializedName("seconds")
	SECONDS,

	@SerializedName("hour")
	HOUR,

	@SerializedName("day")
	DAY,

	@SerializedName("week")
	WEEK,

	@SerializedName("month")
	MONTH,

	@SerializedName("quarter")
	QUARTER,

	@SerializedName("year")
	YEAR;
}
