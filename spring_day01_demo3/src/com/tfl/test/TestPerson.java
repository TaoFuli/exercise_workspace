package com.tfl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.pojo.Person;

public class TestPerson {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		Person p1=(Person)ctx.getBean("p1");
		Person p2=(Person)ctx.getBean("p1");
		p2.setMessage("滚");
		p2.setName("李四");
		//使用== 判断两个实例对象是不是同一个实例对象
		
		System.out.println(p1==p2?"p1,p2是同一个实例":"p1,p2不是同一个实例");
		p1.say();
		p2.say();
		//关闭容器
		((AbstractApplicationContext) ctx).close();
	}

}
