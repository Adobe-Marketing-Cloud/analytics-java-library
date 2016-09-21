package com.adobe.granite.analytics.client.auth.oauth;

import java.net.HttpURLConnection;
import java.util.Map;

public interface GrantType {
	Map<String, String> getParameters();

	void processRequest(HttpURLConnection conn);
}