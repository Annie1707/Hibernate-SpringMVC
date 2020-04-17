package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//Create object
			Student student = new Student("ashi", "sharma", "ashi@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save object
			session.save(student);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("object saved");
			
			System.out.println("reading object");
			
			//new code:
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("retreived student: "+ myStudent);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
