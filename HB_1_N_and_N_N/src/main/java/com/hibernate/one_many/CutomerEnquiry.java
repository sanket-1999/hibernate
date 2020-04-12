package com.hibernate.one_many;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CutomerEnquiry {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session1 = sessionFactory.openSession();

	/*	 Profile profile = new Profile("IBM", 2);
		Employee emp = new Employee("Name1", 10000, profile);
		session1.beginTransaction();
		session1.save(emp);
		session1.save(profile);
		session1.getTransaction().commit();
		session1.close();
*/
		Session session2 = sessionFactory.openSession();
		Query query = (Query) session2.createQuery("from Employee");
		List<Employee> employeeList = ((org.hibernate.query.Query) query).list();
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		session1.close();

	/*	Session session3 = sessionFactory.openSession();
		Profile profile2 = session3.load(Profile.class, 10L);
		profile2.setExperience(4);
		Employee emp2 = session3.load(Employee.class, 9L);
		emp.setName("Name2");
		emp.setSal(12000.0);
		session3.beginTransaction();
		session3.getTransaction().commit();
		session3.close();

		Session session4 = sessionFactory.openSession();
		Profile profile1 = session4.load(Profile.class, 14L);
		Employee emp1 = session4.load(Employee.class, 23L);
		session4.beginTransaction();
		session4.delete(emp1);
		session4.getTransaction().commit();
		session4.close(); */

	}

}
