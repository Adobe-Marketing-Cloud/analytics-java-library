package com.adobe.analytics.client.domain;

import java.util.List;

public class ReportDescriptionSearch {

	private ReportDescriptionSearchType type;

	private List<String> keywords;

	private List<ReportDescriptionSearch> searches;

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

	public List<ReportDescriptionSearch> getSearches() {
		return searches;
	}

	public void setSearches(List<ReportDescriptionSearch> searches) {
		this.searches = searches;
	}

}
