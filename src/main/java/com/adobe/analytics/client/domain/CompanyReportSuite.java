package com.adobe.analytics.client.domain;

public class CompanyReportSuite {

	private String rsid;

	private String siteTitle;

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

	@Override
	public String toString() {
		return String.format("CompanyReportSuite [rsid=%s, siteTitle=%s]", rsid, siteTitle);
	}

}
