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

import com.google.gson.annotations.SerializedName;

public class Report {

	@SerializedName("type")
	private String type;

	@SerializedName("reportSuite")
	private ReportReportSuite reportSuite;

	@SerializedName("period")
	private String period;

	@SerializedName("elements")
	private List<ReportElement> elements;

	@SerializedName("metrics")
	private List<ReportMetric> metrics;

	@SerializedName("segments")
	private List<ReportSegment> segments;

	@SerializedName("data")
	private List<ReportData> data;

	@SerializedName("totals")
	private List<Double> totals;

	@SerializedName("version")
	private String version;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ReportReportSuite getReportSuite() {
		return reportSuite;
	}

	public void setReportSuite(ReportReportSuite reportSuite) {
		this.reportSuite = reportSuite;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<ReportElement> getElements() {
		return elements;
	}

	public void setElements(List<ReportElement> elements) {
		this.elements = elements;
	}

	public List<ReportMetric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<ReportMetric> metrics) {
		this.metrics = metrics;
	}

	public List<ReportSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<ReportSegment> segments) {
		this.segments = segments;
	}

	public List<ReportData> getData() {
		return data;
	}

	public void setData(List<ReportData> data) {
		this.data = data;
	}

	public List<Double> getTotals() {
		return totals;
	}

	public void setTotals(List<Double> totals) {
		this.totals = totals;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
