package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public enum AllocationTypeEnum {

	@SerializedName("most_recent_last")
	MOST_RECENT_LAST,

	@SerializedName("original_value_first")
	ORIGINAL_VALUE_FIRST,

	@SerializedName("linear")
	LINEAR,

	@SerializedName("linear_to_items")
	LINEAR_TO_ITEMS,

	@SerializedName("merchandising_last")
	MERCHANDISING_LAST,

	@SerializedName("merchandising_first")
	MERCHANDISING_FIRST;

}
