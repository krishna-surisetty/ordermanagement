package com.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_email",unique=true)
	private String customerEmail;

	//@JoinColumn(name="customer_id")
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> orders=new ArrayList<>();

	public Customer(String customerName, String customerEmail) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}
	
	public void setOrder(Order order) {
		orders.add(order);
	}
	
}
