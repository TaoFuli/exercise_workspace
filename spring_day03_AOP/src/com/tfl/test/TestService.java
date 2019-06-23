package com.tfl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.service.UserService;

public class TestService {

	@Test
	public void testSe() {
		//读取配置文件，初始化上下文对象
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config2.xml");
		UserService service=ctx.getBean(UserService.class);
		service.search(10);
		service.remove(100);
		((AbstractApplicationContext) ctx).close();
	}
}
