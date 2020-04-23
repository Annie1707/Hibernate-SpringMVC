package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//Create object
//			Instructor instructor=new Instructor("anushi","agrawal","anushi@gmail.com");
//			InstructorDetail detail = new InstructorDetail("http://youtube.com/anushi","coding");
			
			Instructor instructor=new Instructor("disha","behrani","disha@gmail.com");
			InstructorDetail detail = new InstructorDetail("http://youtube.com/disha","cooking");
			
			instructor.setInstructorDetail(detail);
			//start transaction
			session.beginTransaction();
			
			//save object
			session.save(instructor);
			System.out.println(instructor);
			//commit
			session.getTransaction().commit();
			
			System.out.println("object saved");
			
		}finally {
			factory.close();
		}

	}

}
