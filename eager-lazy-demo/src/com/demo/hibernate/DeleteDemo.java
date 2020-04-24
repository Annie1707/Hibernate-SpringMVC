package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Student;

public class DeleteDemo {

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
			
			//start transaction
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor=session.get(Instructor.class, id);
			
			System.out.println(instructor);
			
			if(instructor!=null) {
				session.delete(instructor);
			}
			//save object
			//commit
			session.getTransaction().commit();
			
			System.out.println("object deleted");
			
		}finally {
			factory.close();
		}

	}

}
