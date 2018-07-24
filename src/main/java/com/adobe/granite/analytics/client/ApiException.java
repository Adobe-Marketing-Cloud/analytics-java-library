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

package com.adobe.granite.analytics.client;

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
