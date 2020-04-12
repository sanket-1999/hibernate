package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CheckingCaching {

	public static void main(String[] args) throws InterruptedException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Product product = new Product("Table", 1200);
		session.beginTransaction();
		session.save(product);
		Product p1 = session.get(Product.class, product.getId());
		Product p2 = session.get(Product.class, product.getId());
		session.getTransaction().commit();
		//session.evict(product_1);
		session.close();
		
		//Thread.sleep(5000);
		//sessionFactory.getCache().evictEntity(Product.class,product.getId());
		System.out.println("Start");
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Product p3 = session1.get(Product.class, product.getId());
		session1.getTransaction().commit();
		System.out.println("End");
		session1.close();

	}

}
