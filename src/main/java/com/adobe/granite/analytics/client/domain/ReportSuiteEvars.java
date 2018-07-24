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

public class ReportSuiteEvars {

	private String rsid;

	private String siteTitle;

	private List<Evar> evars;

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

	public List<Evar> getEvars() {
		return evars;
	}

	public void setEvars(List<Evar> evars) {
		this.evars = evars;
	}

	@Override
	public String toString() {
		return String.format("ReportSuiteEvars [rsid=%s, siteTitle=%s, evars=%s]", rsid, siteTitle, evars);
	}

}
