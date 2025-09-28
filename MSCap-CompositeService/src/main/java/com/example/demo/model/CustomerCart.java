package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCart {
	
	@Id
	private int customerId;
	private int cartId;
	public CustomerCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerCart(int customerId, int cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	

}
