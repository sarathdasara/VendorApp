package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
	@Id
	@Column
	private int id;
	@Column
	private String itemName;
	@Column
	private double itemCost;
	@Column
	private double discount;
	@Column
	private int costId;
	public Item() {
		super();
	}
	public Item(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemCost=" + itemCost + ", discount=" + discount
				+ ", costId=" + costId + "]";
	}

}
