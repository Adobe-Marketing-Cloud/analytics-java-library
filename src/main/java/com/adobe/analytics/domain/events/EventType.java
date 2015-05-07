package com.adobe.analytics.domain.events;

import com.google.gson.annotations.SerializedName;

public enum EventType {

	@SerializedName("disabled") DISABLED,
	@SerializedName("counter_no_subrelations") COUNTER_NO_SUBRELATIONS,
	@SerializedName("counter") COUNTER,
	@SerializedName("currency_no_subrelations") CURRENCY_NO_SUBRELATIONS,
	@SerializedName("currency") CURRENCY,
	@SerializedName("numeric_no_subrelations") NUMERIC_NO_SUBRELATIONS,
	@SerializedName("numeric") NUMERIC;
}
