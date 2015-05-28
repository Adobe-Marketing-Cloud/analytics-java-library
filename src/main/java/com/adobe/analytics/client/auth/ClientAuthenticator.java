package com.adobe.analytics.client.auth;

import java.io.IOException;
import java.net.HttpURLConnection;

import com.google.gson.JsonSyntaxException;

public interface ClientAuthenticator {

	void authenticate(HttpURLConnection connection) throws JsonSyntaxException, IOException;

}
