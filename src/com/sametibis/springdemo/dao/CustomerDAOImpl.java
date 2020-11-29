package com.sametibis.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sametibis.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:customerId", Customer.class);
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String keyword) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = null;
		
		if(keyword != null && keyword.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :keyword", Customer.class);
			theQuery.setParameter("keyword", "%"+keyword.toLowerCase()+"%");
		} else {
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> theCustomers = theQuery.getResultList();
		
		return theCustomers;
	}

}
