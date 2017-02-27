package org.com.cay.test;

import java.util.Date;
import java.util.List;

import org.com.cay.entity.Teacher;
import org.com.cay.util.HibernateUtil;
import org.com.cay.util.SessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Session session1 = SessionFactoryUtil.getSessionFactory().openSession();
//		Session session2 = SessionFactoryUtil.getSessionFactory().openSession();
//		System.out.println(session1 == session2);//false
//		
//		Session session3 = SessionFactoryUtil.getSessionFactory().getCurrentSession();
//		Session session4 = SessionFactoryUtil.getSessionFactory().getCurrentSession();
//		System.out.println(session3 == session4);//true
//		
//		session1.close();
//		session2.close();
//		session3.close();
//		session4.close();
		
		OrderById();
	}

	public static void OrderById() {
		Session session = HibernateUtil.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Teacher.class);
		criteria.addOrder(Order.desc("id"));
		List<Teacher> list = criteria.list();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		
		session.close();
	}

	public static void getByName() {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "from Teacher where name = ?";
		Query<Teacher> query = session.createQuery(hql, Teacher.class);
//		query.setString(0, "Cay");
		query.setParameter(0, "Cay");
		Teacher t = query.getSingleResult();
//		query.uniqueResult();
		System.out.println(t);
		
		
		session.close();
	}

	public static void listAll() {
		Session session = HibernateUtil.getCurrentSession();
		
		Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
		List<Teacher> list = query.getResultList();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		session.close();
	}

	public static void deleteTeacher() {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Teacher t = session.get(Teacher.class, 3);
		session.delete(t);
		tx.commit();
		session.close();
	}

	public static void updateTeacher() {
		//修改
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Teacher t = session.load(Teacher.class, 1);
		t.setAge(26);//会自动生成update语句
		//session.update(t);
		tx.commit();
		session.close();
	}

	public static void addTeacher() {
		//添加
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Teacher t = new Teacher();
		t.setName("Cay");
		t.setAge(20);
		t.setEmail("1111@qq.com");
		t.setHiredate(new Date());
		
		//保存到数据库
		session.save(t);
		tx.commit();
		
		session.close();
	}

}
