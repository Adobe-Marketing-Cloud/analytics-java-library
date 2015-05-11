package com.adobe.analytics.client.domain;

import java.util.List;

public class ReportSuiteProps {

	private String rsid;

	private String siteTitle;

	private List<Prop> props;

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

	public List<Prop> getProps() {
		return props;
	}

	public void setProps(List<Prop> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return String.format("ReportSuiteProps [rsid=%s, siteTitle=%s, props=%s]", rsid, siteTitle, props);
	}

}
