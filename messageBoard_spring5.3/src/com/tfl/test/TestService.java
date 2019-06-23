package com.tfl.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.dao.LogDao;
import com.tfl.dao.MessageDao;
import com.tfl.pojo.Message;

public class TestService {
	
	@Test
	public void test1() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		/*MessageDao  dao = ctx.getBean(MessageDao.class);
		Message m = dao.selectById(29);
		System.out.println(m);*/
		
		MessageDao  dao = ctx.getBean(MessageDao.class);
		List<Message>  list = dao.selectAllMessages(1, 3);
		for (Message message : list) {
			System.out.println(message);
		}
		((AbstractApplicationContext) ctx).close();
	}
	
	
	@Test
	public void test2() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		LogDao dao = ctx.getBean(LogDao.class);
		
		//dao.insert("张三，登录");
		List<Map<String,Object>> list = dao.selectAll();
		for (Map<String, Object> map : list) {
			System.out.println(map.values());
		}
		((AbstractApplicationContext) ctx).close();
	}
	
	

}
