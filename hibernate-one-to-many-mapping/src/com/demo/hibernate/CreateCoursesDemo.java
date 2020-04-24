package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			session.beginTransaction();
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);
			
			Course course= new Course("Life is what you make it");
			Course course2 = new Course("5 mistakes of my life");
			
			instructor.add(course);
			instructor.add(course2);
			
			session.save(course);
			session.save(course2);
			//commit
			session.getTransaction().commit();
			
			System.out.println("object saved");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
