package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = new Course("literature");
			
			course.add(new Review("great course"));
			course.add(new Review("I love this course"));
			course.add(new Review("Awesome course"));
			course.add(new Review("not up to the mark"));
			
			session.save(course);
			//commit
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
