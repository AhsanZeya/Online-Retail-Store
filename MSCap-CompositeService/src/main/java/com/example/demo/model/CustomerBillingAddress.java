package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerBillingAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billAddId;
	private int doorNo;
	private String streetName;
	private String layout;
	private String city;
	private String pincode;
	public CustomerBillingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBillingAddress(int billAddId, int doorNo, String streetName, String layout, String city,
			String pincode) {
		super();
		this.billAddId = billAddId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	public int getBillAddId() {
		return billAddId;
	}
	public void setBillAddId(int billAddId) {
		this.billAddId = billAddId;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
