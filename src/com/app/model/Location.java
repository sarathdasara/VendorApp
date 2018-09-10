package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Location {
	@Id
	@Column
	private int locId;
	@Column
	private String locName;
	@Column
	private String locCode;
	@Column
	private String  locType;
	@Column
	private String  locDsc;
	public Location() {
		super();
	}
	public Location(int locId) {
		super();
		this.locId = locId;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	public String getLocDsc() {
		return locDsc;
	}
	public void setLocDsc(String locDsc) {
		this.locDsc = locDsc;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", locCode=" + locCode + ", locType=" + locType
				+ ", locDsc=" + locDsc + "]";
	}
	
}