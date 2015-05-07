package com.adobe.analytics.domain.events;

import com.google.gson.annotations.SerializedName;

public enum EventSerializationType {

	@SerializedName("unavailable") UNAVAILABLE,
	@SerializedName("always_record") ALWAYS_RECORD,
	@SerializedName("record_once_per_visit") RECORD_ONCE_PER_VISIT,
	@SerializedName("record_once_per_unique_id") RECORD_ONCE_PER_UNIQUE_ID;

}
