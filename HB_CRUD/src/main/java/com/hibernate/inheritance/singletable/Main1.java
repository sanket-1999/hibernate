package com.hibernate.inheritance.singletable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.inheritance.tableperclass.Bike1;
import com.hibernate.inheritance.tableperclass.Car1;
import com.hibernate.inheritance.tableperclass.Vehicle1;

public class Main1 {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Vehicle ve = new Vehicle("Tom", 10000);
		Car ca = new Car("Jerry", 20000, 5000);
		Bike bi = new Bike("Ivan", 20000, 5000);
		Transaction tx = session.beginTransaction();
		session.persist(ve);
		session.persist(ca);
		session.persist(bi);
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Bike, car & vehicle saved into single table!!");
	}

}
