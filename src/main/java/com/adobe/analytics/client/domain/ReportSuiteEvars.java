package com.adobe.analytics.client.domain;

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
