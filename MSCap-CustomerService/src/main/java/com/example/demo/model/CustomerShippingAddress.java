package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shipAddId;
	private int doorNo;
	private String streetName;
	private String layout;
	private String city;
	private String pincode;
	public CustomerShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerShippingAddress(int shipAddId, int doorNo, String streetName, String layout, String city,
			String pincode) {
		super();
		this.shipAddId = shipAddId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	public int getShipAddId() {
		return shipAddId;
	}
	public void setShipAddId(int shipAddId) {
		this.shipAddId = shipAddId;
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
