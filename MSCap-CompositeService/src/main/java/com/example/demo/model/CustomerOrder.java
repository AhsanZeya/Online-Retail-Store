package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	
	@Id
	private int id;
	private int customerId;
	private int orderId;
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerOrder(int orderId, int customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
