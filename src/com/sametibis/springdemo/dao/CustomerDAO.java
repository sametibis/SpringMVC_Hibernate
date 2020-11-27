package com.sametibis.springdemo.dao;

import java.util.List;

import com.sametibis.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
