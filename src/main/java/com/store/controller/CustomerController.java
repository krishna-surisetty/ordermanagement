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
import com.store.model.dto.CustomerDto;
import com.store.model.dto.CustomerUpdateDto;
import com.store.model.dto.OrderDto;
import com.store.service.CustomerService;
import com.store.utils.Constants;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<Customer>(customerService.createCustomer(customerDto), HttpStatus.OK);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customerUpdateDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") Long customerId) {
		customerService.deleteCustomer(customerId);
		return Constants.CUSTOMER_IS_DELETED;
	}
	
	
	
//	@PostMapping("/customer/order")
//	public ResponseEntity<Customer> createCustomer(@RequestBody OrderDto orderDto) {
//		return new ResponseEntity<Customer>(customerService.addOrder(orderDto), HttpStatus.OK);
//	}
}
