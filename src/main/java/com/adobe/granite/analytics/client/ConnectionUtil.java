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
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public final class ConnectionUtil {

	private ConnectionUtil() {
	}

	public static String readResponse(HttpURLConnection connection) throws IOException {
		final int status = connection.getResponseCode();
		if (status < 200 || status > 299) {
			final InputStream errorStream = connection.getErrorStream();
			if (errorStream != null) {
				final String errorMessage = IOUtils.toString(errorStream);
				try {
					final JsonObject jsonResult = JsonUtil.GSON.fromJson(errorMessage, JsonObject.class);
					throw new ApiException(jsonResult);
				} catch (JsonSyntaxException e) {
					// it's not a valid JSON, we'll throw an IOException below
				}
			}
			throw new IOException(String.format("HTTP error %d %s", connection.getResponseCode(),
					connection.getResponseMessage()));
		} else {
			return IOUtils.toString(connection.getInputStream());
		}
	}
}
