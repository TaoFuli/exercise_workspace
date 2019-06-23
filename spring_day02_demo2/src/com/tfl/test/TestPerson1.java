package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.PersonService;

public class TestPerson1 {
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("person1_config.xml");
		PersonService service =(PersonService)ctx.getBean("personService1");
		service.remove();
		((AbstractApplicationContext) ctx).close();
	}
}
