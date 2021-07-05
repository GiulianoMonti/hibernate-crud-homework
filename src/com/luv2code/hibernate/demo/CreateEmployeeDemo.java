package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// create a student object
			System.out.println("Creating a new student object...");
			Employee temEmployee = new Employee("DANIEL", "MONTI", "TAKESHI");
			

			
			// start a transaction

			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(temEmployee);

			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("muy bien!!!!");
			System.out.println("Done!");


		} finally {
			factory.close();
		}

	}

}