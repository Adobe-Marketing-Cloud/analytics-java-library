package com.adobe.analytics.domain.variables;

import com.adobe.analytics.domain.evars.ExpirationType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListVariable {

	@Expose
	private int id;

	@Expose
	private String name;

	@Expose
	@SerializedName("allocation_type")
	private ListVarAllocationType allocationType;

	@Expose
	@SerializedName("expiration_type")
	private ExpirationType expirationType;

	@Expose
	@SerializedName("expiration_custom_days")
	private int expirationCustomDays;

	@Expose
	@SerializedName("value_delimiter")
	private String valueDelimiter;

	@Expose
	@SerializedName("max_values")
	private String maxValues;

	@Expose
	@SerializedName("enabled")
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ListVarAllocationType getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(ListVarAllocationType allocationType) {
		this.allocationType = allocationType;
	}

	public ExpirationType getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(ExpirationType expirationType) {
		this.expirationType = expirationType;
	}

	public int getExpirationCustomDays() {
		return expirationCustomDays;
	}

	public void setExpirationCustomDays(int expirationCustomDays) {
		this.expirationCustomDays = expirationCustomDays;
	}

	public String getValueDelimiter() {
		return valueDelimiter;
	}

	public void setValueDelimiter(String valueDelimiter) {
		this.valueDelimiter = valueDelimiter;
	}

	public String getMaxValues() {
		return maxValues;
	}

	public void setMaxValues(String maxValues) {
		this.maxValues = maxValues;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
