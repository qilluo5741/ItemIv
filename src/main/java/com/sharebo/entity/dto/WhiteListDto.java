package com.sharebo.entity.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * ������
 * @author Administrator
 *
 */
public class WhiteListDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String whitelistId;//����
	private String commId;//����
	private String carNo;//���ƺ�
	private String periodvalidity;//��������Ч��
	private Date entrytime;
	private String name;//��������
	private String address;//������ַ�Ż�
	private String phone;//�����绰
	private String cname;//С������
	private Integer isDisable;//�Ƿ�ʧЧ
	private Integer chargeTimeType;//֧��ʱ������(0 :  �¸�    1������   2 ���긶)
	public Integer getChargeTimeType() {
		return chargeTimeType;
	}
	public void setChargeTimeType(Integer chargeTimeType) {
		this.chargeTimeType = chargeTimeType;
	}
	public Integer getIsDisable() {
		return isDisable;
	}
	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getWhitelistId() {
		return whitelistId;
	}
	public void setWhitelistId(String whitelistId) {
		this.whitelistId = whitelistId;
	}
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getPeriodvalidity() {
		return periodvalidity;
	}
	public void setPeriodvalidity(String periodvalidity) {
		this.periodvalidity = periodvalidity;
	}
	public Date getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
