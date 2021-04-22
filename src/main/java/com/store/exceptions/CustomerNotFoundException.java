package com.store.exceptions;

import java.text.MessageFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerNotFoundException extends RuntimeException {
	
	//private Logger logger = Logger.getLogger(CustomerNotFoundException.class.getName());
	
	public CustomerNotFoundException(Long id) {
		super(MessageFormat.format("could not find customer with the id ", id));
		log.error("could not find customer with the id ", id);		
	}
	
}
