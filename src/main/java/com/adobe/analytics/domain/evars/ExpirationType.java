package com.adobe.analytics.domain.evars;

import com.google.gson.annotations.SerializedName;

public enum ExpirationType {
	@SerializedName("custom") CUSTOM,
	@SerializedName("visit") VISIT,
	@SerializedName("page_view") PAGE_VIEW,
	@SerializedName("never") NEVER,
	@SerializedName("minute") MINUTE,
	@SerializedName("hour") HOUR,
	@SerializedName("day") DAY,
	@SerializedName("week") WEEK,
	@SerializedName("month") MONTH,
	@SerializedName("quarter") QUARTER,
	@SerializedName("year") YEAR,
	@SerializedName("purchase") PURCHASE,
	@SerializedName("product_view") PRODUCT_VIEW,
	@SerializedName("cart_open") CART_OPEN,
	@SerializedName("cart_checkout") CART_CHECKOUT,
	@SerializedName("cart_add") CART_ADD,
	@SerializedName("cart_remove") CART_REMOVE,
	@SerializedName("cart_view") CART_VIEW
}
