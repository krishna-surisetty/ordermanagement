package com.store.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.exceptions.CustomerNotFoundException;
import com.store.exceptions.OrderNotFoundException;
import com.store.model.Customer;
import com.store.model.Order;
import com.store.model.dto.OrderDto;
import com.store.model.dto.OrderUpdateDto;
import com.store.repository.CustomerRepository;
import com.store.repository.OrderRepository;
import com.store.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	public Order addOrder(OrderDto orderDto) {
		Customer customerThatIsOrdering = customerRepository.findById(orderDto.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException(orderDto.getCustomerId()));
		Order order = new Order();
		order.setCustomer(customerThatIsOrdering);
		order.setOrderName(orderDto.getOrderName());
		order.setOrderQuantity(orderDto.getOrderQuantity());
		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order updateOrder(OrderUpdateDto orderUpdateDto) {
		Order orderToBeUpdated = getOrder(orderUpdateDto.getOrderId());
		orderToBeUpdated.setOrderQuantity(orderUpdateDto.getOrderQuantity());
		return orderRepository.save(orderToBeUpdated);
	}

	@Override
	public void deleteOrder(Long orderId) {
		getOrder(orderId);
		orderRepository.deleteById(orderId);
	}


	@Override 
	public List<Order> getOrdersByCustomersId(Long customerId) { 
		return orderRepository.getOrdersByCustomerId(customerId); 
	}


}
