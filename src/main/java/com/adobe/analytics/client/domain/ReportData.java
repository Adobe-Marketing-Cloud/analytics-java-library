package com.adobe.analytics.client.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ReportData {

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	@SerializedName("path")
	private List<ReportDataPath> path;

	@SerializedName("parentID")
	private String parentID;

	@SerializedName("year")
	private Integer year;

	@SerializedName("month")
	private Integer month;

	@SerializedName("day")
	private Integer day;

	@SerializedName("hour")
	private Integer hour;

	@SerializedName("minute")
	private Integer minute;

	@SerializedName("trend")
	private Double trend;

	@SerializedName("counts")
	private List<Double> counts;

	@SerializedName("upperBounds")
	private List<Double> upperBounds;

	@SerializedName("lowerBounds")
	private List<Double> lowerBounds;

	@SerializedName("forecasts")
	private List<Double> forecasts;

	@SerializedName("breakdownTotal")
	private List<Double> breakdownTotal;

	@SerializedName("breakdown")
	private List<ReportData> breakdown;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ReportDataPath> getPath() {
		return path;
	}

	public void setPath(List<ReportDataPath> path) {
		this.path = path;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Double getTrend() {
		return trend;
	}

	public void setTrend(Double trend) {
		this.trend = trend;
	}

	public List<Double> getCounts() {
		return counts;
	}

	public void setCounts(List<Double> counts) {
		this.counts = counts;
	}

	public List<Double> getUpperBounds() {
		return upperBounds;
	}

	public void setUpperBounds(List<Double> upperBounds) {
		this.upperBounds = upperBounds;
	}

	public List<Double> getLowerBounds() {
		return lowerBounds;
	}

	public void setLowerBounds(List<Double> lowerBounds) {
		this.lowerBounds = lowerBounds;
	}

	public List<Double> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<Double> forecasts) {
		this.forecasts = forecasts;
	}

	public List<Double> getBreakdownTotal() {
		return breakdownTotal;
	}

	public void setBreakdownTotal(List<Double> breakdownTotal) {
		this.breakdownTotal = breakdownTotal;
	}

	public List<ReportData> getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(List<ReportData> breakdown) {
		this.breakdown = breakdown;
	}
}
