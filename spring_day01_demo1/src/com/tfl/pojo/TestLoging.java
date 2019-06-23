package com.tfl.pojo;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLoging {
	private static Logger logger=Logger.getLogger(TestLoging.class.getName());
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		logger.info("开始运行！");
		logger.warning("开始执行222");
		//logger.debug("");
		Person p=(Person)ctx.getBean("p1");
		p.say();
		//查找bean
//		Person person=ctx.getBean(Person.class);//这里在配置文件有多个类，会抛出异常
//		System.out.println(person);
		logger.info("执行结束");
		System.out.println("-----------");
		System.err.println("------------");
		//关闭容器
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
