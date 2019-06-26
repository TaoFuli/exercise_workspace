package com.igeek.app.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Listener1 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("ServletContext 初始化,创建一个空的在线用户列表的容器放在ServletContext");
		
		List<String> users = new ArrayList<>();
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("users", users);
		
		
	}

}
