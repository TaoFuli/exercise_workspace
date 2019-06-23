package com.tfl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.pojo.Person;

public class TestFactoryBean {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		Person p1=(Person)ctx.getBean("p1");
		Person p2=(Person)ctx.getBean("p2");
		Person p3=(Person)ctx.getBean("p3");
		Person p4=(Person)ctx.getBean("p4");
		Person p5=(Person)ctx.getBean("p5");
		Person p6=(Person)ctx.getBean("p6");
		System.out.println("直接创建bean");
		p1.say();
		System.out.println("静态工厂,factory-method");
		p2.say();
		p3.say();
		System.out.println("实例工厂，直接创建实例，factory-bean,factory-method");
		p4.say();
		p5.say();
		System.out.println("通过FactoryBean工厂实例类创建");
		p6.say();
		//关闭容器
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
