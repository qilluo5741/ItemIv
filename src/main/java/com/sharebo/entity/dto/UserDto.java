package com.sharebo.entity.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userAccount;
	private String userPassword;
	private String isProperty;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getIsProperty() {
		return isProperty;
	}
	public void setIsProperty(String isProperty) {
		this.isProperty = isProperty;
	}
}
