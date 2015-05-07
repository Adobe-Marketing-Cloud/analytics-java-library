package com.adobe.analytics.domain.evars;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EVarsConfiguration {

	@Expose
	private String rsid;
	
	@Expose
	@SerializedName("site_title")
	private String siteTitle;
	
	@Expose
	@SerializedName("evars")
	private List<EVar> evars;

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

	public List<EVar> getEvars() {
		return evars;
	}

	public void setEvars(List<EVar> evars) {
		this.evars = evars;
	}
	
	
}
