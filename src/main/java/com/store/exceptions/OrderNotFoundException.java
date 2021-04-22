package com.store.exceptions;

import java.text.MessageFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderNotFoundException extends RuntimeException {
	
	//private Logger logger = Logger.getLogger(CustomerNotFoundException.class.getName());
	public OrderNotFoundException(Long id) {
		super(MessageFormat.format("could not find order with the id ", id));
		log.error("could not find order with the id ", id);		
	}
}
