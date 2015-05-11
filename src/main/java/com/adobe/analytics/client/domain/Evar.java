package com.adobe.analytics.client.domain;

import java.util.List;

public class Evar {

	private String id;

	private String name;

	private AllocationTypeEnum allocationType;

	private String type;

	private Boolean enabled;

	private String expirationType;

	private Integer expirationCustomDays;

	private String merchandisingSyntax;

	private List<String> bindingEvents;

	public String getId() {
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

	public AllocationTypeEnum getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(AllocationTypeEnum allocationType) {
		this.allocationType = allocationType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(String expirationType) {
		this.expirationType = expirationType;
	}

	public Integer getExpirationCustomDays() {
		return expirationCustomDays;
	}

	public void setExpirationCustomDays(Integer expirationCustomDays) {
		this.expirationCustomDays = expirationCustomDays;
	}

	public String getMerchandisingSyntax() {
		return merchandisingSyntax;
	}

	public void setMerchandisingSyntax(String merchandisingSyntax) {
		this.merchandisingSyntax = merchandisingSyntax;
	}

	public List<String> getBindingEvents() {
		return bindingEvents;
	}

	public void setBindingEvents(List<String> bindingEvents) {
		this.bindingEvents = bindingEvents;
	}

	@Override
	public String toString() {
		return String
				.format("Evar [id=%s, name=%s, allocationType=%s, type=%s, enabled=%s, expirationType=%s, expirationCustomDays=%s, merchandisingSyntax=%s, bindingEvents=%s]",
						id, name, allocationType, type, enabled, expirationType, expirationCustomDays,
						merchandisingSyntax, bindingEvents);
	}
}
