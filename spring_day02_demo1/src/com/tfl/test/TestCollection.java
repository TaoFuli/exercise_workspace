package com.tfl.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.bean.DemoBean1;

public class TestCollection {
	private ApplicationContext ctx;
	
	@Before
	public void doBefore() {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	/**
	 * 测试数组
	 * 
	 */
	@Test
	public void testArray() {
		DemoBean1 d=(DemoBean1)ctx.getBean("demo");
		d.printArray();
	}
	/**
	 * 	测试List
	 */
	@Test
	public void testList() {
		DemoBean1 d=(DemoBean1)ctx.getBean("demo");
		d.printList();
	}
	/**
	 * 	测试Set
	 */
	@Test
	public void testSet() {
		DemoBean1 d=(DemoBean1)ctx.getBean("demo");
		d.printSet();
	}
	
}
