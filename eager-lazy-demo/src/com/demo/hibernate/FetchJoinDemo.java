package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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
			//hibernate query with hql
			int id=1;
			
			Query<Instructor> query=session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId",Instructor.class);
			
			query.setParameter("theInstructorId",id);
			
			Instructor instructor=query.getSingleResult();
			
			System.out.println("demo: the instructor is: "+instructor);
			
			
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
