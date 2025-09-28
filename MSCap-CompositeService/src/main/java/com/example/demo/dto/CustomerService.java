package com.example.demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.CustomerBillingAddress;
import com.example.demo.model.CustomerShippingAddress;

@Component
public class CustomerService {
	
	private int id;
	private String customerName;
	private String customerEmail;
	private List<CustomerBillingAddress> customerBillingAddress;
	private List<CustomerShippingAddress> customerShippingAddress;
	
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerService(int id, String customerName, String customerEmail,
			List<CustomerBillingAddress> customerBillingAddress,
			List<CustomerShippingAddress> customerShippingAddress) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public List<CustomerBillingAddress> getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(List<CustomerBillingAddress> customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	public List<CustomerShippingAddress> getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(List<CustomerShippingAddress> customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	
	
	

}
