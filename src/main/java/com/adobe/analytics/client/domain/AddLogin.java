package com.adobe.analytics.client.domain;

import java.util.Date;
import java.util.List;

public class AddLogin {

	private boolean createDashboards;

	private String email;

	private String firstName;

	private List<String> groupName;

	private boolean isAdmin;

	private boolean isTemp;

	private String lastName;

	private String login;

	private boolean mustChangePassword;

	private String password;

	private String phoneNumber;

	private String rsid;

	private Date tempEndDate;

	private Date tempStartDate;

	private String title;

	public boolean isCreateDashboards() {
		return createDashboards;
	}

	public void setCreateDashboards(boolean createDashboards) {
		this.createDashboards = createDashboards;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<String> getGroupName() {
		return groupName;
	}

	public void setGroupName(List<String> groupName) {
		this.groupName = groupName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isTemp() {
		return isTemp;
	}

	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isMustChangePassword() {
		return mustChangePassword;
	}

	public void setMustChangePassword(boolean mustChangePassword) {
		this.mustChangePassword = mustChangePassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRsid() {
		return rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public Date getTempEndDate() {
		return tempEndDate;
	}

	public void setTempEndDate(Date tempEndDate) {
		this.tempEndDate = tempEndDate;
	}

	public Date getTempStartDate() {
		return tempStartDate;
	}

	public void setTempStartDate(Date tempStartDate) {
		this.tempStartDate = tempStartDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
