package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class DeletingCourseDemo {

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
			
			Course course=session.get(Course.class, 10);
			
			System.out.println("course to be deleted: "+course);
			
			session.delete(course);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
