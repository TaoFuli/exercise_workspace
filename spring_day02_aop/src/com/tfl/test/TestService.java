package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.CustomerService;

public class TestService {
	@Test
	public void testSave() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config.xml");
		CustomerService service=(CustomerService)ctx.getBean("customerService");
		service.save();
		service.find();
		((AbstractApplicationContext) ctx).close();
	}
}
