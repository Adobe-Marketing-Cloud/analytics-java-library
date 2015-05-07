package com.adobe.analytics.domain.events;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsConfiguration {

	@Expose
	private String rsid;
	
	@Expose
	@SerializedName("site_title")
	private String siteTitle;
	
	@Expose
	@SerializedName("ecommerce_level")
	private String eccomerceLevel;

	@Expose
	@SerializedName("events")
	private List<Event> events;

	public String getRsid() {
		return rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}
	
	public String getEccomerceLevel() {
		return eccomerceLevel;
	}

	public void setEccomerceLevel(String eccomerceLevel) {
		this.eccomerceLevel = eccomerceLevel;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
