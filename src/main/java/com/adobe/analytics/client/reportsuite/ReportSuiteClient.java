package com.adobe.analytics.client.reportsuite;

import java.io.IOException;
import java.util.List;

import com.adobe.analytics.client.AnalyticsClient;
import com.adobe.analytics.domain.evars.EVarsConfiguration;
import com.adobe.analytics.domain.events.Event;
import com.adobe.analytics.domain.events.EventsConfiguration;
import com.adobe.analytics.domain.events.SaveEventsRequest;
import com.adobe.analytics.domain.props.Prop;
import com.adobe.analytics.domain.props.PropsConfiguration;
import com.adobe.analytics.domain.props.SavePropsRequest;
import com.adobe.analytics.domain.variables.ListVariablesConfiguration;
import com.google.gson.JsonElement;

public class ReportSuiteClient {

	private final AnalyticsClient client;

	public ReportSuiteClient(AnalyticsClient client) {
		this.client = client;
	}

	public EVarsConfiguration[] getEVarsConfiguration(String... rsid) throws IOException {
		final ReportSuiteId request = new ReportSuiteId(rsid);
		return client.callMethod("ReportSuite.GetEvars", request, EVarsConfiguration[].class);
	}

	public PropsConfiguration[] getPropsConfiguration(String... rsid) throws IOException {
		final ReportSuiteId request = new ReportSuiteId(rsid);
		return client.callMethod("ReportSuite.GetProps", request, PropsConfiguration[].class);
	}

	public EventsConfiguration[] getEventsConfiguration(String... rsid) throws IOException {
		final ReportSuiteId request = new ReportSuiteId(rsid);
		return client.callMethod("ReportSuite.GetEvents", request, EventsConfiguration[].class);
	}

	public ListVariablesConfiguration[] getListVarsConfiguration(String... rsid) throws IOException {
		final ReportSuiteId request = new ReportSuiteId(rsid);
		return client.callMethod("ReportSuite.GetListVariables", request, ListVariablesConfiguration[].class);
	}

	public JsonElement savePropsConfiguration(List<Prop> props, String... rsid) throws IOException {
		final SavePropsRequest request = new SavePropsRequest(props, rsid);
		return client.callMethod("ReportSuite.SaveProps", request, JsonElement.class);
	}

	public JsonElement saveEventsConfiguration(List<Event> events, String... rsid) throws IOException {
		final SaveEventsRequest request = new SaveEventsRequest(events, rsid);
		return client.callMethod("ReportSuite.SaveEvents", request, JsonElement.class);
	}
}
