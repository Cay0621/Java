package org.com.cay.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	private static ThreadLocal<Session> localSession = null;
	
	public HibernateUtil(){
		
	}
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		localSession = new ThreadLocal<Session>();
		
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		Session session = localSession.get();
		if(session == null){
			session = openSession();
			localSession.set(session);
		}
		return session;
	}
	
}
