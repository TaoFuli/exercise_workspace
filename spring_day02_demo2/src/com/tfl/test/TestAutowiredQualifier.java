package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.PersonService2;

public class TestAutowiredQualifier {
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("autowired_config.xml");
		PersonService2 service=(PersonService2)ctx.getBean("personService");
		service.remove();
		((AbstractApplicationContext) ctx).close();
	}
}
