package com.tfl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.pojo.Person;
import com.tfl.pojo.User;

public class TestIocDI {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p1=(Person)ctx.getBean("p1");
		User u1=(User)ctx.getBean("u1");
		p1.say();
		u1.say();
		Person p2=(Person)ctx.getBean("p2");
		p2.say();
		((AbstractApplicationContext) ctx).close();
	}

}
