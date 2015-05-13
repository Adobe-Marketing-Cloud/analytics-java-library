package com.adobe.analytics.client.domain;

public class ReportDescriptionSegment {

	private String id;

	private String element;

	private ReportDescriptionSegmentSearch search;

	private String classification;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public ReportDescriptionSegmentSearch getSearch() {
		return search;
	}

	public void setSearch(ReportDescriptionSegmentSearch search) {
		this.search = search;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
