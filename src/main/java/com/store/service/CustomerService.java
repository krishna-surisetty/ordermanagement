package com.store.service;

import java.util.List;

import com.store.model.Customer;
import com.store.model.dto.CustomerDto;
import com.store.model.dto.CustomerUpdateDto;
import com.store.model.dto.OrderDto;

public interface CustomerService {
	
	public Customer getCustomer(Long customerId);
	public List<Customer> getAllCustomers();
	public Customer createCustomer(CustomerDto customerDto);
	public Customer updateCustomer(CustomerUpdateDto customerUpdateDto);
	public boolean deleteCustomer(Long customerId);
	//public Customer addOrder(OrderDto orderDto);
}
