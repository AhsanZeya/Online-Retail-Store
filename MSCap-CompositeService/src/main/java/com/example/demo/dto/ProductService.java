package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductService {
	

	private int id;
	private String productName;
	private String productDescription;
	private int quantity;
	private int price;
	public ProductService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductService(int id, String productName, String productDescription, int quantity, int price) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
