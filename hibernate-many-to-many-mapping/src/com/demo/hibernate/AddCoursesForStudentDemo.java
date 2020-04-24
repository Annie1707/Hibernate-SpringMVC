package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;
import com.demo.hibernate.entity.Student;

public class AddCoursesForStudentDemo {

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
			
			int id = 4;
			Student student = session.get(Student.class, id);
			
			System.out.println("the student is: "+student);
			
			System.out.println("student has courses: "+student.getCourses());
			
			Course course1 = new Course("youtube class");
			Course course2 = new Course("game development");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			
			//commit
			session.getTransaction().commit();
			System.out.println("later courses: "+student.getCourses());
			System.out.println("done");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
