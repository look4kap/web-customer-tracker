package com.westchester.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westchester.springdemo.dao.CustomerDAO;
import com.westchester.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional("demoTransactionManager")
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional("demoTransactionManager")
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional("demoTransactionManager")
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}

}
