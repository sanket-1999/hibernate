package com.hibernate.FirstHibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MyApp {

	public static void getvsload(SessionFactory sessionFactory) {

		/*
		 * Session session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); tx.begin(); Product product =
		 * session.load(Product.class, 12L);
		 * System.out.println("Details : = "+product.getId()+product.getName()+product.
		 * getPrice()); tx.commit(); session.close();
		 */

		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		tx1.begin();
		Product product1 = session1.get(Product.class, 12L);

		System.out.println("Details : = " + product1.getId() + product1.getName() + product1.getPrice());
		tx1.commit();
		session1.close();

	}

	public static void updatevsmerge(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, 11L);
		session.close();
		product.setName("neww Tables");

		Session session1 = sessionFactory.openSession();
		Transaction tx = session1.beginTransaction();
		tx.begin();
		session1.update(product);
		tx.commit();
		session1.close();
	}

	public static void persistvssave(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Product product = new Product("checking", 12);
		session.persist(product);
		tx.commit();
		session.close();

	}

	public static void insertwithsql(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		//Query query1 = session.createSQLQuery("SELECT * FROM PRODUCT_MASTER");
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery("INSERT INTO PRODUCT_MASTER (p_id,name,cost,city) VALUES(111,'abcd',12,'dfsdf')");
		query.executeUpdate();
		
		
		List<Object[]> prodList = query.list();
		for (Object obj[] : prodList) {
			System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + obj[3]);
		}
		transaction.commit();
		session.close();
	}
	
	public static void totalsal (SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		//Query query = session.createSQLQuery("SELECT SUM(P.cost) FROM PRODUCT_MASTER P GROUP BY P.NAME");
		
		
		String sumHql = "SELECT SUM(price) FROM Product ";
		Query sumQuery = session.createQuery(sumHql);
		System.out.println(sumQuery.list().get(0));
		
		session.close();
	}
	
	
	public static void listbyname(SessionFactory sessionFactory) {
	/*	Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Product.class); //criteria
		cr.addOrder(Order.asc("price"));
		
		List results = cr.list();
		System.out.println("\n"+results);
		session.close();
		*/
		
		Session sesson1=sessionFactory.openSession();
		
	//	Query  query = sesson1.createQuery("FROM Product P WHERE P.PRICE > 0 ORDER BY P.PRICE"); // hql
		
		
	
		String Hql = "FROM Product P WHERE price > 0 ORDER BY price";
		Query nameQuery = sesson1.createQuery(Hql);
		List<Product> productList = nameQuery.list();
		System.out.println(productList);
		sesson1.close();
	}

	
	public static void sortbyname(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		String Hql = "FROM Product P  ORDER BY name";
		Query nameQuery = session.createQuery(Hql);
		List<Product> productList = nameQuery.list();
		System.out.println(productList);
		session.close();
		
		
	}
	
	
	public static void avg(SessionFactory sessionFactory)
	{
		Session session  = sessionFactory.openSession();
		String sumHql = "SELECT AVG(price) FROM Product ";
		Query sumQuery = session.createQuery(sumHql);
		System.out.println(sumQuery.list().get(0));
		
		session.close();
	}
	
	
	public static void salarymorethan(SessionFactory sessionFactory) {
		Session session  = sessionFactory.openSession();
		String Hql = "FROM Product P WHERE price > 10000 ORDER BY price";
		Query salarygreater = session.createQuery(Hql);
		List<Product> productList = salarygreater.list();
		System.out.println(productList);
		session.close();
	}
	
	
	public static void named(SessionFactory sessionFactory) {
		Session session  = sessionFactory.openSession();
		Query q=session.getNamedQuery("GET_ALL_PRODUCT");
		List<Product> plist=q.list();
		
	}
	
	
	public static List<Product> getAllProducts(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Product> productList = query.list();
		return productList;
	}

	public static void update(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Product product = session.load(Product.class, 16L);
		product.setName("Tables");
		tx.commit();
		session.close();

	}

	public static void delete(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Product product = session.load(Product.class, 10L);
		session.delete(product);
		tx.commit();
		session.close();

	}

	public static void insert(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Product product = new Product("Chairs", 5000);
		long productId = (Long) session.save(product);
		tx.commit();
		System.out.println(productId);
		session.close();

	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// insert(sessionFactory);
		// System.out.println(getAllProducts(sessionFactory));
		// update(sessionFactory);
		// delete(sessionFactory);
		// getvsload(sessionFactory);
		// updatevsmerge(sessionFactory);
		// persistvssave(sessionFactory);
		 insertwithsql(sessionFactory);
		// totalsal(sessionFactory);
		//listbyname(sessionFactory);
		//sortbyname(sessionFactory);
		 //avg(sessionFactory);
		
	//	salarymorethan(sessionFactory);
		
	//	named(sessionFactory);
		
		
		sessionFactory.close();
	}

}