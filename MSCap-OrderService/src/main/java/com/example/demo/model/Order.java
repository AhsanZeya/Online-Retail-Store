package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="Orders")
public class Order {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="orderId")
	private List<OrderLineItem> lineItem;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, List<OrderLineItem> lineItem) {
		super();
		this.orderId = orderId;
		this.lineItem = lineItem;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderLineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<OrderLineItem> lineItem) {
		this.lineItem = lineItem;
	}
	
}
