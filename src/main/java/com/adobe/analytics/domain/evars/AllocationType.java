package com.adobe.analytics.domain.evars;

import com.google.gson.annotations.SerializedName;

public enum AllocationType {

	@SerializedName("most_recent_last") MOST_RECENT_LAST,
	@SerializedName("original_value_first") ORIGINAL_VALUE_FIRST,
	@SerializedName("linear") LINEAR,
	@SerializedName("merchandising_first") MERCHANDISING_FIRST,
	@SerializedName("merchandising_last") MERCHANDISING_LAST;

}
