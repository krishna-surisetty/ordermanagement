package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	
	 @Query(value = "SELECT * FROM ORDER WHERE CUSTOMER_ID=:customersId", nativeQuery = true) 
	// @Query("SELECT U FROM ORDERS U WHERE U.CUSTOMER =:customerId") 
	 public List<Order> getOrdersByCustomerId(@Param("customersId") Long customerId);
	 
}
