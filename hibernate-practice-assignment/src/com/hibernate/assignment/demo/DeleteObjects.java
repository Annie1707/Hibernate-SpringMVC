package com.hibernate.assignment.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteObjects {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		session.beginTransaction();
		
		Employee employee=session.get(Employee.class, 1);
		
		session.delete(employee);
		
		session.getTransaction().commit();
		
		System.out.println("done ");
		
		
	}finally {
		factory.close();
	}
		
		
	}
}
