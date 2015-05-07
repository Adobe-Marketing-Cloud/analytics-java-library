package com.adobe.analytics.domain.props;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropsConfiguration {

	@Expose
	private String rsid;
	
	@Expose
	@SerializedName("site_title")
	private String siteTitle;
	
	@Expose
	@SerializedName("props")
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
	
}
