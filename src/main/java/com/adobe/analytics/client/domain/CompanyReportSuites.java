package com.adobe.analytics.client.domain;

import java.util.List;

public class CompanyReportSuites {

	private List<CompanyReportSuite> reportSuites;

	public List<CompanyReportSuite> getReportSuites() {
		return reportSuites;
	}

	public void setReportSuites(List<CompanyReportSuite> reportSuites) {
		this.reportSuites = reportSuites;
	}

	@Override
	public String toString() {
		return String.format("CompanyReportSuites [reportSuites=%s]", reportSuites);
	}

}
