package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.UserService;

public class testAfterMethod {
	
	@Test
	public void testThrowExceptionMethod() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:AfterReturnningMethod_config.xml");
		UserService service=ctx.getBean(UserService.class);
		service.edit(100, "张三");
		service.search(10);
		service.remove(101);
		((AbstractApplicationContext) ctx).close();
	}
}
