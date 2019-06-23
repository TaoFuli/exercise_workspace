package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.bean.Tools;

public class TestCalculatorTools {
	@Test
	public void testTools() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("tools_config.xml");
		Tools t=(Tools)ctx.getBean("tools");
		System.out.println("1+2="+t.add(1, 2));
		((AbstractApplicationContext) ctx).close();
	}
}
