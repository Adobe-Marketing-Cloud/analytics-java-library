package com.adobe.analytics.domain.props;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prop {
	@Expose
	private String id;

	@Expose
	private String name;

	@Expose
	private Boolean enabled;

	@Expose
	private String description;

	@Expose
	@SerializedName("pathing_enabled")
	private Boolean pathingEnabled;

	@Expose
	@SerializedName("list_enabled")
	private Boolean listEnabled;

	@Expose
	@SerializedName("list_delimiter")
	private String listDelimeter;

	@Expose
	@SerializedName("participation_enabled")
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getListDelimeter() {
		return listDelimeter;
	}

	public void setListDelimeter(String listDelimeter) {
		this.listDelimeter = listDelimeter;
	}

	public Boolean getParticipationEnabled() {
		return participationEnabled;
	}

	public void setParticipationEnabled(Boolean participationEnabled) {
		this.participationEnabled = participationEnabled;
	}

}
