package com.adobe.analytics.client.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ReportDescription {

	@SerializedName("reportSuiteID")
	protected String reportSuiteID;

	@SerializedName("date")
	protected String date;

	@SerializedName("dateFrom")
	protected String dateFrom;

	@SerializedName("dateTo")
	protected String dateTo;

	@SerializedName("dateGranularity")
	protected ReportDescriptionDateGranularity dateGranularity;

	@SerializedName("source")
	protected ReportDescriptionSource source;

	@SerializedName("metrics")
	protected List<ReportDescriptionMetric> metrics;

	@SerializedName("elements")
	protected List<ReportDescriptionElement> elements;

	@SerializedName("locale")
	protected ReportDescriptionLocale locale;

	@SerializedName("sortMethod")
	protected String sortMethod;

	@SerializedName("sortBy")
	protected String sortBy;

	@SerializedName("segments")
	protected List<ReportDescriptionSegment> segments;

	@SerializedName("anomalyDetection")
	protected Boolean anomalyDetection;

	@SerializedName("currentData")
	protected Boolean currentData;

	@SerializedName("expedite")
	protected Boolean expedite;

	@SerializedName("elementDataEncoding")
	protected ReportDescriptionElementDataEncoding elementDataEncoding;

}
