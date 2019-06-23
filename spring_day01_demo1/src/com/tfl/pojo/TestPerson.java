package com.tfl.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p=(Person)ctx.getBean("p1");
		Person p1=(Person)ctx.getBean("p2");
		p.say();
		p1.say();
		((AbstractApplicationContext) ctx).close();
	}

}
