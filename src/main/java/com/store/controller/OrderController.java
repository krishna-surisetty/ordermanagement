package com.store.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Customer;
import com.store.model.Order;
import com.store.model.dto.CustomerDto;
import com.store.model.dto.CustomerUpdateDto;
import com.store.model.dto.OrderDto;
import com.store.model.dto.OrderUpdateDto;
import com.store.service.CustomerService;
import com.store.service.OrderService;
import com.store.utils.Constants;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> addOrder(@RequestBody OrderDto orderDto) {
		return new ResponseEntity<Order>(orderService.addOrder(orderDto), HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId) {
		return new ResponseEntity<Order>(orderService.getOrder(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}
	
	@PutMapping("/order")
	public ResponseEntity<Order> updateOrder(@RequestBody OrderUpdateDto orderUpdateDto) {
		return new ResponseEntity<Order>(orderService.updateOrder(orderUpdateDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/order/{id}")
	public String deleteOrder(@PathVariable("id") Long orderId) {
		orderService.deleteOrder(orderId);
		return Constants.ORDER_IS_DELETED;
	}
	
	@GetMapping("/order/customer/{id}")
	public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable("id") Long customerId) {
		customerService.getCustomer(customerId);
		return new ResponseEntity<List<Order>>(orderService.getOrdersByCustomersId(customerId), HttpStatus.OK);
	}
	
	
}
