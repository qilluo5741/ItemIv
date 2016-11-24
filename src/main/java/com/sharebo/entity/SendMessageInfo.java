package com.sharebo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ������Ϣ��Ϣ
 * @author niewei
 *
 */
public class SendMessageInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carNo;//���ƺ�
	private String commId;//С����
	private String eqNo;//�豸��
	private String smImg;//СͼƬ
	private Date date;
	private String bigImg;//��ͼƬ
	private Integer isoutin;//�Ƿ���� 1���� 2����
	private Double money;//����
	private String feeInstructions;//�շ�ģʽ˵��
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getEqNo() {
		return eqNo;
	}
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	public String getSmImg() {
		return smImg;
	}
	public void setSmImg(String smImg) {
		this.smImg = smImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	public Integer getIsoutin() {
		return isoutin;
	}
	public void setIsoutin(Integer isoutin) {
		this.isoutin = isoutin;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getFeeInstructions() {
		return feeInstructions;
	}
	public void setFeeInstructions(String feeInstructions) {
		this.feeInstructions = feeInstructions;
	}
	public SendMessageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getDate() {
		return new Date();
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public SendMessageInfo(String carNo, String commId, String eqNo,
			String smImg, String bigImg, Integer isoutin) {
		super();
		this.carNo = carNo;
		this.commId = commId;
		this.eqNo = eqNo;
		this.smImg = smImg;
		this.bigImg = bigImg;
		this.isoutin = isoutin;
	}
	public SendMessageInfo(String carNo, String commId, String eqNo,
			String smImg, String bigImg, Integer isoutin, Double money,
			String feeInstructions) {
		super();
		this.carNo = carNo;
		this.commId = commId;
		this.eqNo = eqNo;
		this.smImg = smImg;
		this.bigImg = bigImg;
		this.isoutin = isoutin;
		this.money = money;
		this.feeInstructions = feeInstructions;
	}
	
}
