package com.adobe.analytics.client.domain;

public class PermissionGroup {

	private String groupid;

	private String groupName;

	private String description;

	private Integer type;

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("PermissionGroup [groupid=%s, groupName=%s, description=%s, type=%s]", groupid,
				groupName, description, type);
	}
}
