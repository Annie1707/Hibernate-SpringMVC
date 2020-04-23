package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			
			System.out.println("deleting student: "+student);
			session.delete(student);
			
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("delete student with id 2");
			
			session.createQuery("delete Student where id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		}finally {
			factory.close();
		}

	}

}
