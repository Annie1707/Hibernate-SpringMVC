package com.psl.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		Session session = factory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer "+"order by lastName",Customer.class);
		
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = factory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id =:customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String input) {
		Session session = factory.getCurrentSession();
		
		Query query = null;
		
		if(input!=null && input.trim().length()>0) {
			query=session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",Customer.class);
			query.setParameter("name", "%" + input.toLowerCase()+"%");
		}
		else
			query=session.createQuery("from Customer",Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
