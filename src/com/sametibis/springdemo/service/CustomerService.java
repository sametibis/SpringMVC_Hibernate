package com.sametibis.springdemo.service;

import java.util.List;

import com.sametibis.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
