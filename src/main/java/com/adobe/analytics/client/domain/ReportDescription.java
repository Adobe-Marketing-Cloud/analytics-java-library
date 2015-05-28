package com.adobe.analytics.client.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ReportDescription {

	@SerializedName("reportSuiteID")
	private String reportSuiteID;

	@SerializedName("date")
	private String date;

	@SerializedName("dateFrom")
	private String dateFrom;

	@SerializedName("dateTo")
	private String dateTo;

	@SerializedName("dateGranularity")
	private ReportDescriptionDateGranularity dateGranularity;

	@SerializedName("source")
	private ReportDescriptionSource source;

	@SerializedName("metrics")
	private List<ReportDescriptionMetric> metrics;

	@SerializedName("elements")
	private List<ReportDescriptionElement> elements;

	@SerializedName("locale")
	private ReportDescriptionLocale locale;

	@SerializedName("sortMethod")
	private String sortMethod;

	@SerializedName("sortBy")
	private String sortBy;

	@SerializedName("segments")
	private List<ReportDescriptionSegment> segments;

	@SerializedName("anomalyDetection")
	private Boolean anomalyDetection;

	@SerializedName("currentData")
	private Boolean currentData;

	@SerializedName("expedite")
	private Boolean expedite;

	@SerializedName("elementDataEncoding")
	private ReportDescriptionElementDataEncoding elementDataEncoding;

	public String getReportSuiteID() {
		return reportSuiteID;
	}

	public void setReportSuiteID(String reportSuiteID) {
		this.reportSuiteID = reportSuiteID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public ReportDescriptionDateGranularity getDateGranularity() {
		return dateGranularity;
	}

	public void setDateGranularity(ReportDescriptionDateGranularity dateGranularity) {
		this.dateGranularity = dateGranularity;
	}

	public ReportDescriptionSource getSource() {
		return source;
	}

	public void setSource(ReportDescriptionSource source) {
		this.source = source;
	}

	public List<ReportDescriptionMetric> getMetrics() {
		return metrics;
	}

	public void setMetricIds(String... metricIds) {
		List<ReportDescriptionMetric> newMetrics = new ArrayList<>();
		for (final String id : metricIds) {
			final ReportDescriptionMetric metric = new ReportDescriptionMetric();
			metric.setId(id);
			newMetrics.add(metric);
		}
		setMetrics(newMetrics);
	}

	public void setMetrics(List<ReportDescriptionMetric> metrics) {
		this.metrics = metrics;
	}

	public List<ReportDescriptionElement> getElements() {
		return elements;
	}

	public void setElementIds(String... elementIds) {
		List<ReportDescriptionElement> newElements = new ArrayList<>();
		for (final String id : elementIds) {
			final ReportDescriptionElement element = new ReportDescriptionElement();
			element.setId(id);
			newElements.add(element);
		}
		setElements(newElements);
	}

	public void setElements(List<ReportDescriptionElement> elements) {
		this.elements = elements;
	}

	public ReportDescriptionLocale getLocale() {
		return locale;
	}

	public void setLocale(ReportDescriptionLocale locale) {
		this.locale = locale;
	}

	public String getSortMethod() {
		return sortMethod;
	}

	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public List<ReportDescriptionSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<ReportDescriptionSegment> segments) {
		this.segments = segments;
	}

	public Boolean getAnomalyDetection() {
		return anomalyDetection;
	}

	public void setAnomalyDetection(Boolean anomalyDetection) {
		this.anomalyDetection = anomalyDetection;
	}

	public Boolean getCurrentData() {
		return currentData;
	}

	public void setCurrentData(Boolean currentData) {
		this.currentData = currentData;
	}

	public Boolean getExpedite() {
		return expedite;
	}

	public void setExpedite(Boolean expedite) {
		this.expedite = expedite;
	}

	public ReportDescriptionElementDataEncoding getElementDataEncoding() {
		return elementDataEncoding;
	}

	public void setElementDataEncoding(ReportDescriptionElementDataEncoding elementDataEncoding) {
		this.elementDataEncoding = elementDataEncoding;
	}

}
