package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class QueryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//start transaction
					session.beginTransaction();
				
					//get all students
					List<Student> allStudents = session.createQuery("from Student").getResultList();
					
					//display all students
					displayStudents(allStudents);
					
					//get student whose last name is agrawal
					allStudents=session.createQuery("from Student s where s.lastName='agrawal'").getResultList();
					displayStudents(allStudents);
					
					//get students whose last name is agrawal or first name is disha
					allStudents=session.createQuery("from Student s where" + " s.lastName='agrawal' OR s.firstName = 'disha'").getResultList();
					displayStudents(allStudents);
					
					//get students whose email ends with shi@gmail.com
					allStudents=session.createQuery("from Student s where" + " s.email LIKE '%shi@gmail.com'").getResultList();
					displayStudents(allStudents);
					
					//commit
					session.getTransaction().commit();
					System.out.println("done");
					
				}finally {
					factory.close();
				}
	}

	private static void displayStudents(List<Student> allStudents) {
		for(Student s:allStudents)
			System.out.println(s);
	}

}
