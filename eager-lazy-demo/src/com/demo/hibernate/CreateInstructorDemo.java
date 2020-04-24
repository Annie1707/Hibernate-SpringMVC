package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor=new Instructor("aashi","sharma","aashi@gmail.com");
			InstructorDetail detail = new InstructorDetail("http://youtube.com/aashi","eating");
			
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
			session.close();
			factory.close();
		}

	}

}
