package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public enum ReportDescriptionSearchType {

	@SerializedName("and")
	AND,

	@SerializedName("or")
	OR,

	@SerializedName("not")
	NOT;
}
