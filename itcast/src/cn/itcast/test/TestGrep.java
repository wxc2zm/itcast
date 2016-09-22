package cn.itcast.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import cn.itcast.test.entity.Person;
import cn.itcast.test.service.TestService;

public class TestGrep {
	
	ClassPathXmlApplicationContext ct;
	@Before
	public void loadCt() {
		ct = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSpring() {
		TestService testService = (TestService) ct.getBean("testService");
		testService.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sessionFactory = (SessionFactory) ct.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("人员2"));
		transaction.commit();
		session.close();
	}

}
