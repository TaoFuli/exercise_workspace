package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.PersonService2;

public class TestResource {
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("resource_config.xml");
		PersonService2 service=(PersonService2)ctx.getBean("personService");
		service.remove();
		((AbstractApplicationContext) ctx).close();
	}
}
