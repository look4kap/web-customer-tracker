package com.westchester.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.westchester.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//1. Inject session factory
	
	@Autowired
	@Qualifier(value="demoSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		//1. get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//2. create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//3.execute query and get resultset
		List<Customer> customers = theQuery.getResultList();
		
		//4.return results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		//1. get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//saving the obj to DB
		currentSession.save(customer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		//1. get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//2. create query
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//4.return results
		return theCustomer;	
	}

}
