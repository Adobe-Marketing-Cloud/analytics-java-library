package com.adobe.analytics.client.auth;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Calendar;

public abstract class OAuthenticator implements ClientAuthenticator {

	private String accessToken;

	private Calendar expires;

	abstract void getToken() throws JsonSyntaxException, IOException;

	@Override
	public void authenticate(HttpURLConnection connection) throws JsonSyntaxException, IOException {
		if (!isTokenValid()) {
			getToken();
		}
		connection.addRequestProperty("Authorization", String.format("Bearer %s", accessToken));
	}


	private boolean isTokenValid() {
		final Calendar now = Calendar.getInstance();
		return accessToken != null && now.before(expires);
	}

	private void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	private void setExpires(Calendar expires) {
		this.expires = expires;
	}

	protected void getTokenJSONResponse(JsonObject response) {
		setAccessToken(response.get("access_token").getAsString());
		Calendar expires = Calendar.getInstance();
		expires.add(Calendar.SECOND, response.get("expires_in").getAsInt());
		setExpires(expires);
	}
}
