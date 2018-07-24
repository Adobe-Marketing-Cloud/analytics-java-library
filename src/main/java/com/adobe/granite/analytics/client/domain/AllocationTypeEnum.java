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

package com.adobe.granite.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public enum AllocationTypeEnum {

	@SerializedName("most_recent_last")
	MOST_RECENT_LAST,

	@SerializedName("original_value_first")
	ORIGINAL_VALUE_FIRST,

	@SerializedName("linear")
	LINEAR,

	@SerializedName("linear_to_items")
	LINEAR_TO_ITEMS,

	@SerializedName("merchandising_last")
	MERCHANDISING_LAST,

	@SerializedName("merchandising_first")
	MERCHANDISING_FIRST;

}
