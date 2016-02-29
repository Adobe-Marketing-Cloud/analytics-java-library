package com.adobe.analytics.client.domain;

import com.google.gson.annotations.SerializedName;

public class Bookmark {


	@SerializedName("rsid")
	private String rsid;

	public String getRsid() {
		return rsid;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	@SerializedName("name")
	private String name;
	
	@SerializedName("id")
	private long id;


}
