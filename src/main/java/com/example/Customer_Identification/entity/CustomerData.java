package com.example.Customer_Identification.entity;


import jakarta.persistence.Entity;


import jakarta.persistence.Id;
@Entity
public class CustomerData {
	@Id
	
	private String customer_Id;
	private String customer_Name;
	public CustomerData(String customer_Id, String customer_Name) {
		super();
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
	}
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	@Override
	public String toString() {
		return "CustomerData [customer_Id=" + customer_Id + ", customer_Name=" + customer_Name + "]";
	}
	public CustomerData() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
