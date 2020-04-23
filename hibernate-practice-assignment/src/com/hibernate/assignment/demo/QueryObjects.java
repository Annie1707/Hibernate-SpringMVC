package com.hibernate.assignment.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryObjects {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		session.beginTransaction();
		
		List<Employee> allEmployees = session.createQuery("from Employee e where e.company='psl'").getResultList();
		
		for(Employee e : allEmployees)
			System.out.println(e);
		
		session.getTransaction().commit();
		
		System.out.println("done ");
		
		
	}finally {
		factory.close();
	}
		
		
	}
}
