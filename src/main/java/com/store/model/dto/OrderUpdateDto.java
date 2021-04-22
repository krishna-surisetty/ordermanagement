package com.store.model.dto;

import lombok.Getter;

@Getter
public class OrderUpdateDto {
	private Long orderId;
	private int orderQuantity;
}
