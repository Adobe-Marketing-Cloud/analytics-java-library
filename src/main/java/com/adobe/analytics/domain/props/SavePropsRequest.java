package com.adobe.analytics.domain.props;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavePropsRequest {

	@Expose
	@SerializedName("rsid_list")
	private String[] rsid;

	@Expose
	private List<Prop> props;

	public SavePropsRequest(List<Prop> props, String... rsid) {
		this.rsid = rsid;
		this.props = props;
	}

}
