package com.adobe.analytics.domain.events;

import com.google.gson.annotations.SerializedName;

public enum EventParticipationType {

	@SerializedName("unavailable") UNAVAILABLE,
	@SerializedName("disabled") DISABLED,
	@SerializedName("enabled") ENABLED;
}
