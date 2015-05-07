package com.adobe.analytics.domain.evars;

import com.google.gson.annotations.SerializedName;

public enum MerchSyntaxType {

	@SerializedName("product") PRODUCT_SYNTAX,
	@SerializedName("conversion_variable") CONVERSION_VARIABLE_SYNTAX;

}
