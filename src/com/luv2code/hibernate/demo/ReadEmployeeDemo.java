package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// create a student object
			System.out.println("Creating a new employee object...");
			Employee tempEmployee = new Employee("takeshi", "kovacs", "kovacs@gmail.com");

			// start a transaction

			session.beginTransaction();

			// save the student object
			System.out.println(tempEmployee);
			System.out.println(tempEmployee);

			session.save(tempEmployee);

			// commit transaction

			session.getTransaction().commit();

			// MY NEW CODE

			// find out the student's id: primary key
			System.out.println("Saved employee. Generated id: " + tempEmployee.getId());

			// now get a new session and start transaction

			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key

			System.out.println("\nGetting employee with id: " + tempEmployee.getId());

			Employee myStudent = session.get(Employee.class, tempEmployee.getId());

			System.out.println("Get complete: " + myStudent);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}


// session.createQuery("from Student").getResultList()