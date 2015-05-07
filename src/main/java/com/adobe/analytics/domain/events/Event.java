package com.adobe.analytics.domain.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

	@Expose
	private String id;
	
	@Expose
	private String name;
	
	@Expose
	private String description;
	
	@Expose
	private EventType type;
	
	@Expose
	@SerializedName("default_metric")
	private boolean defaultMetric;
	
	@Expose
	private EventParticipationType participation;
	
	@Expose
	private EventSerializationType serialization;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public boolean isDefaultMetric() {
		return defaultMetric;
	}

	public void setDefaultMetric(boolean defaultMetric) {
		this.defaultMetric = defaultMetric;
	}

	public EventParticipationType getParticipation() {
		return participation;
	}

	public void setParticipation(EventParticipationType participation) {
		this.participation = participation;
	}

	public EventSerializationType getSerialization() {
		return serialization;
	}

	public void setSerialization(EventSerializationType serialization) {
		this.serialization = serialization;
	}
	
}
