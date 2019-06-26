package com.igeek.app.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class Listener4 implements ServletContextAttributeListener,ServletRequestAttributeListener,HttpSessionAttributeListener
{

	// 1. 监听Session中的属性的  添加 移除 修改
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Session中属性	被添加");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session中属性	被移除");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session中属性 被替换");
	}
	
	// 2. 监听Request中的属性的  添加 移除 修改

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("Request中属性 被添加");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("Request中属性 被移除");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("Request中属性 被替换");
	}

	// 3. 监听ServletContext中的属性的  添加 移除 修改
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext中属性 被添加");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext中属性 被移除");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext中属性 被替换");
	}

	

}
