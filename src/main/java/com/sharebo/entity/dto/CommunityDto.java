package com.sharebo.entity.dto;

import java.io.Serializable;

public class CommunityDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String commId;
	private String commVal;
	private String createtime;
	private String commName;
	public int isBanOnForeignCars;//是否允许外来车辆入内
	public int getIsBanOnForeignCars() {
		return isBanOnForeignCars;
	}
	public void setIsBanOnForeignCars(int isBanOnForeignCars) {
		this.isBanOnForeignCars = isBanOnForeignCars;
	}
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getCommVal() {
		return commVal;
	}
	public void setCommVal(String commVal) {
		this.commVal = commVal;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
}
