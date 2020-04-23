package com.hibernate.assignment.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadObjects {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		session.beginTransaction();
		
		List<Employee> allEmployees = session.createQuery("from Employee").getResultList();
		
		for(Employee e : allEmployees)
			System.out.println(e);
		
		session.getTransaction().commit();
		
		//Retrieve object by primary key
		session = factory.getCurrentSession();
		session.beginTransaction();
		int employeeId = 1;
		Employee employee = session.get(Employee.class, employeeId);
		
		System.out.println("employee wth id 1 is: "+employee);
		
		session.getTransaction().commit();
		
		System.out.println("done ");
		
		
	}finally {
		factory.close();
	}
		
		
	}
}
