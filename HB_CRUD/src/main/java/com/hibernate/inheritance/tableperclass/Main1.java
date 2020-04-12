package com.hibernate.inheritance.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.inheritance.singletable.Bike;
import com.hibernate.inheritance.singletable.Car;
import com.hibernate.inheritance.singletable.Vehicle;

public class Main1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Vehicle1 ve = new Vehicle1("Tom", 10000);
		Car1 ca = new Car1("Jerry", 20000, 5000);
		Bike1 bi = new Bike1("Ivan", 20000, 5000);
		Transaction tx = session.beginTransaction();
		session.persist(ve);
		session.persist(ca);
		session.persist(bi);
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Employee, Labour & Manager saved into separate table!!");
	}

	}


