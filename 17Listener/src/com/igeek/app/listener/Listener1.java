package com.igeek.app.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener1 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext 销毁了");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext 创建");
	}

}
