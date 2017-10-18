package com.adobe.analytics.client.domain;

import com.adobe.granite.analytics.client.domain.ReportDescription;
import com.google.gson.annotations.SerializedName;

public class ReportDescriptionResponse {

	
	@SerializedName("name")
	private String name;
	
	@SerializedName("reportType")
	private String reportType;
	
	@SerializedName("reportDescription")
	private ReportDescription reportDescription;
	
	public ReportDescription getReportDescription() {
		return this.reportDescription;
	}
}
