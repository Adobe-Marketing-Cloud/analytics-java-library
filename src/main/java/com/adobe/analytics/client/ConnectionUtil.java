package com.adobe.analytics.client;

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
