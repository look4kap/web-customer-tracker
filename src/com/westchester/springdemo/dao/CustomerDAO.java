package com.westchester.springdemo.dao;

import java.util.List;
import com.westchester.springdemo.entity.Customer;

public interface CustomerDAO {

	public List <Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);
	
	
}
