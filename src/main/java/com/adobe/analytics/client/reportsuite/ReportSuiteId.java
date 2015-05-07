package com.adobe.analytics.client.reportsuite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReportSuiteId {

	@Expose
	@SerializedName("rsid_list")
	private String[] rsid;

	public ReportSuiteId(String... rsid) {
		this.rsid = rsid;
	}
}
