package com.chat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ChatApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("Options:");
			System.out.println("A) Create a chatroom");
			System.out.println("B) Add the user");
			System.out.println("C) User login");
			System.out.println("D) Send a message");
			System.out.println("E) Display the messages from a specific chatroom");
			System.out.println("F) List down all users belonging to the specified chat room.");
			System.out.println("G) Logout");
			System.out.println("H) Delete an user");
			System.out.println("I) Delete the chat room.");
			System.out.println("J) Exit the application");
			System.out.println("Please enter your option:");
			char n = sc.nextLine().charAt(0);
			switch (n) {
			
			case 'A' :
			{
				ChatRooms cr = new ChatRooms("chatroom 1");
				session.beginTransaction();
				session.save(cr);
				session.getTransaction().commit();
				session.close();
			}
			break;
			
			case 'B': 
			{
				Session session1 = sessionFactory.openSession();
				User ur = new User("username", "password");
				session1.beginTransaction();
				session1.save(ur);
				session1.getTransaction().commit();
				session1.close();
				
			}
			
			case 'C':
			{
				Session session2 = sessionFactory.openSession();
				Query query=session2.createSQLQuery("SELECT username , password , CASE WHEN username = 'username' & password = 'password' ");
				
			}
			
			
			
			}
			
			
				
		}
	}
}