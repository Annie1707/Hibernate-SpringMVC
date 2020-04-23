package com.hibernate.assignment.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateObjects {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		Employee employee1=new Employee("anushi","agrawal","psl");
		Employee employee2=new Employee("aashi","sharma","psl");
		Employee employee3=new Employee("dibbi","dadlani","aitr");
		Employee employee4=new Employee("disha","behrani","aitr");
		
		session.beginTransaction();
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		
		session.getTransaction().commit();
		
		System.out.println("objects created ");
		
		
	}finally {
		factory.close();
	}
		
		
	}
}
