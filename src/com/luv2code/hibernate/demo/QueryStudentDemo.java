package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();

			// display the students
			displayEmployees(theEmployees);
			


			theEmployees = session.createQuery("from Employee s where s.lastName= 'Monti'").getResultList();

			// display the students
			System.out.println("\n\nEmployees who have last name of Monti");
			displayEmployees(theEmployees);


			theEmployees = session.createQuery("from Employee s where s.lastName= 'Monti' OR s.firstName='Takeshi'")
					.getResultList();

			// display the students
			System.out.println("\n\nEmployees who have last name of Monti OR Takeshi");
			displayEmployees(theEmployees);

			theEmployees = session.createQuery("from Employee s where s.company LIKE '%shi'").getResultList();

			// display the students
			System.out.println("\n\nEmployee who company ends with shi");

			displayEmployees(theEmployees);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempStudent : theEmployees) {
			System.out.println(tempStudent);
		}
	}

}
