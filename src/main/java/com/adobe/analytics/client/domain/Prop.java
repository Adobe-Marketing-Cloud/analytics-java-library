package com.adobe.analytics.client.domain;

public class Prop {

	private String id;

	private String name;

	private Boolean enabled;

	private Boolean pathingEnabled;

	private Boolean listEnabled;

	private String listDelimiter;

	private Boolean participationEnabled;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getPathingEnabled() {
		return pathingEnabled;
	}

	public void setPathingEnabled(Boolean pathingEnabled) {
		this.pathingEnabled = pathingEnabled;
	}

	public Boolean getListEnabled() {
		return listEnabled;
	}

	public void setListEnabled(Boolean listEnabled) {
		this.listEnabled = listEnabled;
	}

	public String getListDelimiter() {
		return listDelimiter;
	}

	public void setListDelimiter(String listDelimiter) {
		this.listDelimiter = listDelimiter;
	}

	public Boolean getParticipationEnabled() {
		return participationEnabled;
	}

	public void setParticipationEnabled(Boolean participationEnabled) {
		this.participationEnabled = participationEnabled;
	}

	@Override
	public String toString() {
		return String
				.format("Prop [id=%s, name=%s, enabled=%s, pathingEnabled=%s, listEnabled=%s, listDelimiter=%s, participationEnabled=%s]",
						id, name, enabled, pathingEnabled, listEnabled, listDelimiter, participationEnabled);
	}

}
