package com.hibernate.one_many;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

	/*	session.beginTransaction();
		Question q1 = new Question();
		q1.setQusDesc("Question");
		Answer a1 = new Answer("ans1",q1);
		Answer a2 = new Answer("ans2",q1);
		session.save(q1);
		session.save(a1);
		session.save(a2);
		Set<Answer> list = new HashSet<Answer>();
		list.add(a1);list.add(a1);
		
		q1.setAnswers(list);
		session.getTransaction().commit();
		session.close(); 
		 
		
		
		Session session2 = sessionFactory.openSession();
		Query query = (Query) session2.createQuery("from Question");
		List<Question> list1 = ((org.hibernate.query.Query) query).list();
		for (Question e : list1) {
			System.out.println(e);
		}
		
		session.close();
		
		
		Session session3 = sessionFactory.openSession();
		Question ques = session3.load(Question.class, 1L);
		ques.setQusDesc("Updated");
		Answer ans = session3.load(Answer.class, 3L);
		ans.setAnswer("updated A");
		session3.beginTransaction();
		session3.getTransaction().commit();
		session3.close();
		
		*/
		
		Session session4 = sessionFactory.openSession();
		Question ques1 = session4.load(Question.class, 1L);
		Answer ans1 = session4.load(Answer.class, 3L);
		session4.beginTransaction();
		session4.delete(ques1);
		session4.getTransaction().commit();
		session4.close(); 
		
		
		
		
		
		
		

	}

}
