package com.igeek._3LifeCycle;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/life")
public class LifeCycleServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		// 创建Servlet时候被调用
		System.out.println("init() 被调用了");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() 被调用了");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 被调用了");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// 应用被移除 或者是 服务器关闭时调用
		System.out.println("destroy() 被调用了");
	}

}
