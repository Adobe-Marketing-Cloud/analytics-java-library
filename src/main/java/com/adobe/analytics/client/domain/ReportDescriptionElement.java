package com.adobe.analytics.client.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ReportDescriptionElement {

	@SerializedName("id")
	private String id;

	@SerializedName("classification")
	private String classification;

	@SerializedName("top")
	private Integer top;

	@SerializedName("startingWith")
	private Integer startingWith;

	@SerializedName("search")
	private ReportDescriptionSearch search;

	@SerializedName("selected")
	private List<String> selected;

	@SerializedName("parentID")
	private String parentID;

	@SerializedName("checkpoints")
	private List<String> checkpoints;

	@SerializedName("pattern")
	private List<List<String>> pattern;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getStartingWith() {
		return startingWith;
	}

	public void setStartingWith(Integer startingWith) {
		this.startingWith = startingWith;
	}

	public ReportDescriptionSearch getSearch() {
		return search;
	}

	public void setSearch(ReportDescriptionSearch search) {
		this.search = search;
	}

	public List<String> getSelected() {
		return selected;
	}

	public void setSelected(List<String> selected) {
		this.selected = selected;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public List<String> getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(List<String> checkpoints) {
		this.checkpoints = checkpoints;
	}

	public List<List<String>> getPattern() {
		return pattern;
	}

	public void setPattern(List<List<String>> pattern) {
		this.pattern = pattern;
	}

}
