package com.adobe.analytics.client;

import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ApiException extends IOException {

	private static final long serialVersionUID = -5272768785166925793L;

	private final String error;

	private final String errorDescription;

	private final JsonElement json;

	public ApiException(JsonElement json) {
		final JsonObject errorObject = json.getAsJsonObject();
		this.error = errorObject.get("error").getAsString();
		this.errorDescription = errorObject.get("error_description").getAsString();
		this.getLocalizedMessage();
		this.json = json;
	}

	@Override
	public String getMessage() {
		return String.format("%s (%s)", error, errorDescription);
	}

	public String getError() {
		return error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public JsonElement getJson() {
		return json;
	}

}
