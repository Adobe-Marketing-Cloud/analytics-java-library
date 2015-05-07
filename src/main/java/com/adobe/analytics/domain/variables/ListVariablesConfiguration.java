package com.adobe.analytics.domain.variables;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListVariablesConfiguration {

	@Expose
	private String rsid;

	@Expose
	@SerializedName("site_title")
	private String siteTitle;

	@Expose
	@SerializedName("list_variables")
	private List<ListVariable> ListVariables;

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

	public List<ListVariable> getListVariables() {
		return ListVariables;
	}

	public void setListVariables(List<ListVariable> listVariables) {
		this.ListVariables = listVariables;
	}

}
