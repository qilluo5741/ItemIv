package com.sharebo.entity;

import java.io.Serializable;
/**
 * �շ�ģʽ
 * @author Administrator
 *
 */
public class FeeType implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double money;
	private Integer feeModel;//(1:��Сʱ�շ�   2:�����շ�)
	private Double maxMoney;//��߷���
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getFeeModel() {
		return feeModel;
	}
	public void setFeeModel(Integer feeModel) {
		this.feeModel = feeModel;
	}
	public Double getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(Double maxMoney) {
		this.maxMoney = maxMoney;
	}
}
