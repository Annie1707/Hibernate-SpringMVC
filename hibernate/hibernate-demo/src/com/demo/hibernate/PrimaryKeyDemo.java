package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//Create object
					Student student1 = new Student("anushi", "agrawal", "anushi@gmail.com");
					Student student2 = new Student("disha", "behrani", "disha@gmail.com");
					Student student3 = new Student("dibbi", "dadlani", "dibbi@gmail.com");
					//start transaction
					session.beginTransaction();
					
					//save object
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit
					session.getTransaction().commit();
					
					System.out.println("object saved");
					
				}finally {
					factory.close();
				}
	}

}
