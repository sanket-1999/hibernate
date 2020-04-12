package com.hibernate.inheritance.tablepersubclass;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.inheritance.tableperclass.Bike1;
import com.hibernate.inheritance.tableperclass.Car1;
import com.hibernate.inheritance.tableperclass.Vehicle1;

public class Main2 {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Vehicle2 ve = new Vehicle2("Tom", 10000);
		Car2 ca = new Car2("Jerry", 20000, 5000);
		Bike2 bi = new Bike2("Ivan", 20000, 5000);
		Transaction tx = session.beginTransaction();
		session.persist(ve);
		session.persist(ca);
		session.persist(bi);
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Employee, Labour & Manager saved into separate tables with foreign key relation!!");
	}

}
