package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;
import com.demo.hibernate.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course course = new Course("literature");
			session.save(course);
			Student student1 = new Student("anushi", "agrawal", "anushi@gmail.com");
			Student student2= new Student("aashi", "sharma", "aashi@gmail.com");
			Student student3 = new Student("disha", "behrani", "disha@gmail.com");
			course.addStudent(student1);
			course.addStudent(student2);
			course.addStudent(student3);
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println(course.getStudents());
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
