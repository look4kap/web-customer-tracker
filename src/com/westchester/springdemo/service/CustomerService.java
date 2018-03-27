package com.westchester.springdemo.service;

import java.util.List;

import com.westchester.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);
	
}
