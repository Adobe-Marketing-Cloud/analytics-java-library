package com.adobe.analytics.domain.evars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EVar {

	@Expose
	private String id;

	@Expose
	private String name;
	
	@Expose
	private String description;

	@Expose
	@SerializedName("allocation_type")
	private AllocationType allocationType;

	@Expose
	private EvarType type;

	@Expose
	private boolean enabled;
	
	@Expose
	@SerializedName("expiration_type")
	private ExpirationType expirationType;

	@Expose
	@SerializedName("expiration_custom_days")
	private int numberOfPeriods;

	@Expose
	@SerializedName("merchandising_syntax")
	private MerchSyntaxType merchSyntaxType = MerchSyntaxType.CONVERSION_VARIABLE_SYNTAX;

	@Expose
	@SerializedName("binding_events")
	private String[] bindingEvent;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AllocationType getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(AllocationType allocationType) {
		this.allocationType = allocationType;
	}

	public EvarType getType() {
		return type;
	}

	public void setType(EvarType type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ExpirationType getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(ExpirationType expirationType) {
		this.expirationType = expirationType;
	}

	public int getNumberOfPeriods() {
		return numberOfPeriods;
	}

	public void setNumberOfPeriods(int numberOfPeriods) {
		this.numberOfPeriods = numberOfPeriods;
	}

	public MerchSyntaxType getMerchSyntaxType() {
		return merchSyntaxType;
	}

	public void setMerchSyntaxType(MerchSyntaxType merchSyntaxType) {
		this.merchSyntaxType = merchSyntaxType;
	}

	public String[] getBindingEvents() {
		return bindingEvent;
	}

	public void setBindingEvents(String[] bindingEvent) {
		this.bindingEvent = bindingEvent;
	}

}
