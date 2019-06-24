package com.RequestListener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListenerDemo implements ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		//获取请求变量
		String varName=srae.getName();
		Object varValue=srae.getValue();
		System.out.println("请求作用域变量："+varName+"创建了，值是"+varValue);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		String varName=srae.getName();
		Object varValue=srae.getValue();
		System.out.println("请求作用域变量："+varName+"移除了，值是"+varValue);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		String varName=srae.getName();
		Object varValue=srae.getValue(); //获取的是改变前的值
		System.out.println("请求作用域变量："+varName+"改变了，值是"+varValue);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequest sr=sre.getServletRequest();
		HttpServletRequest request=(HttpServletRequest)sr;
		String url=request.getRequestURI().toString();
		String client=request.getRemoteHost();
		System.out.println(client+",销毁了请求："+url);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequest sr=sre.getServletRequest();
		HttpServletRequest request=(HttpServletRequest)sr;
		String url=request.getRequestURI().toString();
		String client=request.getRemoteHost();
		System.out.println(client+",创建了请求："+url);
	}
	
}