/*
Copyright 2018 Adobe. All rights reserved.
This file is licensed to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy
of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
OF ANY KIND, either express or implied. See the License for the specific language
governing permissions and limitations under the License.
*/

package com.adobe.granite.analytics.client.domain;

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
