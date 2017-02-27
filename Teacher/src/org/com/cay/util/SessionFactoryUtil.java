package org.com.cay.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * SessionFactory工具类
 * @author Cay
 *	一个工程只有一个SessionFactory
 *	一个数据库对应一个SessionFactory
 */
public final class SessionFactoryUtil {

	private static SessionFactory sessionFactory = null;
	private SessionFactoryUtil(){
		
	}
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
