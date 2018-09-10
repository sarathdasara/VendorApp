package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vendor {
	@Id
	@Column
	private int venId;
	@Column
	private String venCode;
	@Column
	private String venName;
	@Column
	private String venType;
	@Column
	private String venAdd;
	@Column
	private String idType;
	@Column
	private String idNum;
	@Column
	private String venDsc;
	public Vendor() {
		super();
	}
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getVenAdd() {
		return venAdd;
	}
	public void setVenAdd(String venAdd) {
		this.venAdd = venAdd;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getVenDsc() {
		return venDsc;
	}
	public void setVenDsc(String venDsc) {
		this.venDsc = venDsc;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName=" + venName + ", venType=" + venType
				+ ", venAdd=" + venAdd + ", idType=" + idType + ", idNum=" + idNum + ", venDsc=" + venDsc + "]";
	}

	

}
