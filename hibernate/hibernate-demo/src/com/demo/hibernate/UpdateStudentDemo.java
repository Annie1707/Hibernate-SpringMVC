package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//start transaction
			session.beginTransaction();
			//get student with studenId
			Student student=session.get(Student.class,studentId);
			System.out.println("student with id "+studentId+ " is: "+student);
			
			System.out.println("updating student");
			student.setFirstName("scooby");
			System.out.println(student);
			
			session.getTransaction().commit();
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("updating all students email id ");
			
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		}finally {
			factory.close();
		}

	}

}
