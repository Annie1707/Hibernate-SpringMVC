package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			System.out.println("demo: the instructor is: "+instructor);
			//call getter when session is open
			System.out.println("demo: courses of the instructor: "+instructor.getCourses());
			//commit
			session.getTransaction().commit();
			session.close();
			System.out.println("\n\nsession is closed\n\n\n");
			System.out.println("demo: courses of the instructor: "+instructor.getCourses());
			
			System.out.println("demo: object saved");
			
		}finally {
			
			factory.close();
		}

	}

}
