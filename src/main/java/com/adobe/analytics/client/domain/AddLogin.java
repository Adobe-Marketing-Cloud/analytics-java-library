package com.adobe.analytics.client.domain;

import java.util.Calendar;
import java.util.List;

public class AddLogin {

	private Integer admin;

	private Integer changePassword;

	private Integer createDashboards;

	private String dashboardRsid;

	private String email;

	private String firstName;

	private String lastName;

	private String login;

	private String password;

	private String phoneNumber;

	private List<PermissionGroup> selectedGroupList;

	private Integer tempLogin;

	private Calendar tempLoginEnd;

	private Calendar tempLoginStart;

	private String title;

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Integer getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Integer changePassword) {
		this.changePassword = changePassword;
	}

	public Integer getCreateDashboards() {
		return createDashboards;
	}

	public void setCreateDashboards(Integer createDashboards) {
		this.createDashboards = createDashboards;
	}

	public String getDashboardRsid() {
		return dashboardRsid;
	}

	public void setDashboardRsid(String dashboardRsid) {
		this.dashboardRsid = dashboardRsid;
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

	public List<PermissionGroup> getSelectedGroupList() {
		return selectedGroupList;
	}

	public void setSelectedGroupList(List<PermissionGroup> selectedGroupList) {
		this.selectedGroupList = selectedGroupList;
	}

	public Integer getTempLogin() {
		return tempLogin;
	}

	public void setTempLogin(Integer tempLogin) {
		this.tempLogin = tempLogin;
	}

	public Calendar getTempLoginEnd() {
		return tempLoginEnd;
	}

	public void setTempLoginEnd(Calendar tempLoginEnd) {
		this.tempLoginEnd = tempLoginEnd;
	}

	public Calendar getTempLoginStart() {
		return tempLoginStart;
	}

	public void setTempLoginStart(Calendar tempLoginStart) {
		this.tempLoginStart = tempLoginStart;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String
				.format("AddLogin [admin=%s, changePassword=%s, createDashboards=%s, dashboardRsid=%s, email=%s, firstName=%s, lastName=%s, login=%s, password=%s, phoneNumber=%s, selectedGroupList=%s, tempLogin=%s, tempLoginEnd=%s, tempLoginStart=%s, title=%s]",
						admin, changePassword, createDashboards, dashboardRsid, email, firstName, lastName,
						login, password, phoneNumber, selectedGroupList, tempLogin, tempLoginEnd,
						tempLoginStart, title);
	}
}
