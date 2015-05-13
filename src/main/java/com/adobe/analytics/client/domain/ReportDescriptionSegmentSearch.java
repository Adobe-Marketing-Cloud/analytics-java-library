package com.adobe.analytics.client.domain;

import java.util.List;

public class ReportDescriptionSegmentSearch {

	private ReportDescriptionSearchType type;

	private List<String> keywords;

	public ReportDescriptionSearchType getType() {
		return type;
	}

	public void setType(ReportDescriptionSearchType type) {
		this.type = type;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

}
