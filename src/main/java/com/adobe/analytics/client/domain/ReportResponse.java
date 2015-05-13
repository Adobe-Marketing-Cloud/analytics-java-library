package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public class ReportResponse {

	@SerializedName("waitSeconds")
	private float waitSeconds;

	@SerializedName("runSeconds")
	private float runSeconds;

	@SerializedName("report")
	private Report report;

	public float getWaitSeconds() {
		return waitSeconds;
	}

	public void setWaitSeconds(float waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	public float getRunSeconds() {
		return runSeconds;
	}

	public void setRunSeconds(float runSeconds) {
		this.runSeconds = runSeconds;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
