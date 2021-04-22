package com.store.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.store.model.Order;
import com.store.model.dto.OrderDto;
import com.store.model.dto.OrderUpdateDto;

public interface OrderService {

	public Order addOrder(OrderDto orderDto);
	public Order getOrder(Long orderId);
	public List<Order> getAllOrders();
	public Order updateOrder(OrderUpdateDto orderUpdateDto);
	public void deleteOrder(Long orderId);
	
	//@Query(value = "SELECT * FROM ORDER_TABLE o WHERE o.CUSTOMER_ID = ?1")
	public List<Order> getOrdersByCustomersId(Long customerId);
	
}
