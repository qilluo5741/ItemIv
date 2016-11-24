package com.sharebo.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String roleId;//角色主键
	private String userAccount;//用户账号
	private String equipmentNo;//绑定的设备号
	private int isProperty;//是否物业(0：不是1:是)  如果是物业：代表能访问全部菜单  否则：参照角色
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public int getIsProperty() {
		return isProperty;
	}
	public void setIsProperty(int isProperty) {
		this.isProperty = isProperty;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", roleId=" + roleId
				+ ", userAccount=" + userAccount + ", equipmentNo="
				+ equipmentNo + ", isProperty=" + isProperty + "]";
	}
	
}
