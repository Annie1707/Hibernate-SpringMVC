package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Student;

public class DeleteInstructordetailDemo {

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
			int id = 3;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("deleteing instructor details: "+detail);
			System.out.println("not deleting associated instructor: "+detail.getInstructor());
			//remove the link
			
			detail.getInstructor().setInstructorDetail(null);
			session.delete(detail);
			//commit
			session.getTransaction().commit();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
