package com.adobe.analytics.domain.evars;

import com.google.gson.annotations.SerializedName;

public enum EvarType {
	@SerializedName("text_string") TEXT,
	@SerializedName("counter") COUNTER;
}
