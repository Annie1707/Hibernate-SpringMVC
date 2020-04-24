package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;
import com.demo.hibernate.entity.Student;

public class GetCoursesForStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 5;
			Student student = session.get(Student.class, id);
			
			System.out.println("the student is: "+student);
			
			System.out.println("student has courses: "+student.getCourses());
			
			
			//commit
			session.getTransaction().commit();
			System.out.println("done");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
