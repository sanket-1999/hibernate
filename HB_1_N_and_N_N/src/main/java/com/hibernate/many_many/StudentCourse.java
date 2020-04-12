package com.hibernate.many_many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.one_many.Answer;
import com.hibernate.one_many.Question;

public class StudentCourse {

	public static void insert(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Student s2 = new Student("tom");
		Student s3 = new Student("jerry");
		Course c1 = new Course("java");
		Course c2 = new Course("C");
		Set<Course> list = new HashSet<Course>();
		list.add(c1);
		list.add(c2);
		Student s1 = new Student("tim", list);
		Set<Student> list1 = new HashSet<Student>();
		list1.add(s2);
		list1.add(s3);
		Course c3 = new Course("C++", list1);
		session.save(s1);
		session.save(c3);
		session.getTransaction().commit();
		session.close();
	}

	public static void read(SessionFactory sessionFactory) {
		Session session2 = sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = (Query) session2.createQuery("from Student");
		List<Student> list11 = ((org.hibernate.query.Query) query).list();
		for (Student e : list11) {
			System.out.println(e);
		}

		session2.close();

	}

	public static void update(SessionFactory sessionFactory) {
		Session session3 = sessionFactory.openSession();
		Student student = session3.load(Student.class, 14L);
		student.setStudentName("updated student name");
		Course cr = session3.load(Course.class, 15L);
		cr.setCourseName("updated course");
		session3.beginTransaction();
		session3.getTransaction().commit();
		session3.close();

	}

	public static void delete(SessionFactory sessionFactory) {
		Session session4 = sessionFactory.openSession();
		Course cr11 = session4.load(Course.class, 81L);
		Course cr12 = session4.load(Course.class, 82L);
		Course cr13 = session4.load(Course.class, 83L);
		session4.beginTransaction();
		session4.delete(cr11);
		session4.delete(cr12);
		session4.delete(cr13);
		session4.getTransaction().commit();
		session4.close();
	}

	public static void main(String[] args) {
		

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
	//	insert(sessionFactory);
	//	read(sessionFactory);
	//	update(sessionFactory);
		delete(sessionFactory);
		sessionFactory.close();
	}

}
