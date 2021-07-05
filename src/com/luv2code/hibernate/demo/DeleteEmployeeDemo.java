package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {

			int employeeId = 4;

			// now get a new session and start transaction

			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key

			System.out.println("\nGetting student with id: " + employeeId);

			Employee myEmployee = session.get(Employee.class, employeeId);

			// delete the student

//			System.out.println("Deleting student: " + myEmployee);
//			session.delete(myEmployee);

			// delete student id=2
			System.out.println("Deleting employee id=5");
			session.createQuery("delete from Employee where id=5").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}

// session.createQuery("from Student").getResultList()