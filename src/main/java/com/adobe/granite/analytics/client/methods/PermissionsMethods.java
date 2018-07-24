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

package com.adobe.granite.analytics.client.methods;

import java.io.IOException;

import com.adobe.granite.analytics.client.AnalyticsClient;
import com.adobe.granite.analytics.client.domain.AddLogin;
import com.adobe.granite.analytics.client.JsonUtil;

public class PermissionsMethods {

	private final AnalyticsClient client;

	public PermissionsMethods(AnalyticsClient client) {
		this.client = client;
	}

	public boolean addLogin(AddLogin request) throws IOException {
		final String serializedRequest = JsonUtil.GSON.toJson(request);
		final String response = client.callMethod("Permissions.AddLogin", serializedRequest);
		return "true".equals(response);
	}
}
