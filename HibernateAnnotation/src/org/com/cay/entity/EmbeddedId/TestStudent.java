package org.com.cay.entity.EmbeddedId;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudent {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;
	
	@Before
	public void init(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}
	
	@After
	public void destory(){
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	@Test
	public void testSaveStudents() {
		StudentsPK spk = new StudentsPK();
		spk.setId("123456789");
		spk.setSid("S0000001");
		
		Address addr = new Address("215500","12345678901","常熟市xxx");
		Students student = new Students(spk, "张三丰","男",new Date(),"太极拳",addr);
	
		session.save(student);
	}

}
