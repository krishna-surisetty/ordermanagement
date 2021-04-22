package com.store.model.dto;

public class CustomerDto {
	private String customerName;
	private String customerEmail;

	public CustomerDto() {

	}
	
	public CustomerDto(String customerName, String customerEmail) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
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
}
