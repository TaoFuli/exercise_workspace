package com.tfl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

public class TestService {

	public static void main(String[] args) {
		//读取配置文件
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=(UserService)ctx.getBean("userService");
		service.addUser(new User(10001,"张三","男"));
		System.out.println("添加成功！");
		
//		BeanFactory applicationContext=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		
		//关闭容器
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
