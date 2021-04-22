package com.store.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.exceptions.CustomerNotFoundException;
import com.store.model.Customer;
import com.store.model.Order;
import com.store.model.dto.CustomerDto;
import com.store.model.dto.CustomerUpdateDto;
import com.store.model.dto.OrderDto;
import com.store.repository.CustomerRepository;
import com.store.repository.OrderRepository;
import com.store.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

//	@Autowired
//	private OrderRepository orderRepository;
	
	@Override
	public Customer getCustomer(Long customerId) {
		Customer customerToBeRetrieved = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
		return customerToBeRetrieved;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customersToBeRetrieved = customerRepository.findAll();
		return customersToBeRetrieved;
	}

	@Transactional
	@Override
	public Customer createCustomer(CustomerDto customerDto) {
		Customer customerToBeAdded = new Customer(customerDto.getCustomerName(), customerDto.getCustomerEmail());
		return customerRepository.save(customerToBeAdded);
	}
	
	@Transactional
	public Customer updateCustomer(CustomerUpdateDto customerUpdateDto) {
		Customer customerToBeUpdated = getCustomer(customerUpdateDto.getCustomerId());
		customerToBeUpdated.setCustomerEmail(customerUpdateDto.getCustomerEmail());
		return customerRepository.save(customerToBeUpdated);
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		Customer customerToBeDeleted = getCustomer(customerId);
		customerRepository.delete(customerToBeDeleted);
		return true;
	}

	/*
	 * @Override public Customer addOrder(OrderDto orderDto) { Customer
	 * customerThatIsOrdering = getCustomer(orderDto.getCustomerId()); Order order =
	 * new Order(); order.setOrderName(orderDto.getOrderName());
	 * order.setOrderQuantity(orderDto.getOrderQuantity());
	 * 
	 * customerThatIsOrdering.setOrder(order); orderRepository.save(order); return
	 * customerThatIsOrdering; }
	 */
}
