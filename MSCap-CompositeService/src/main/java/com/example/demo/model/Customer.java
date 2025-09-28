package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerEmail;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private List<CustomerBillingAddress> customerBillingAddress;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private List<CustomerShippingAddress> customerShippingAddress;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String customerEmail,
			List<CustomerBillingAddress> customerBillingAddress, List<CustomerShippingAddress> customerShippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
