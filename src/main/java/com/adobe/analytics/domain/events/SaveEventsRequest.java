package com.adobe.analytics.domain.events;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveEventsRequest {

	@Expose
	@SerializedName("rsid_list")
	private String[] rsid;

	@Expose
	private List<Event> events;

	public SaveEventsRequest(List<Event> events, String... rsid) {
		this.rsid = rsid;
		this.events = events;
	}
}
