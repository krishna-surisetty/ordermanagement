package com.store.model.dto;

public class OrderDto {

	private Long customerId;
	
	private String orderName;
	private int orderQuantity;

	public Long getCustomerId() {
		return customerId;
	}

	public String getOrderName() {
		return orderName;
	}
	
	public int getOrderQuantity() {
		return orderQuantity;
	}

}
