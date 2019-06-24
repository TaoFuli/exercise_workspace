package com.tfl.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<h1 style='color:red;'>进入FirstFilter过滤器</h1>");
		chain.doFilter(req, resp);
		out.println("<h1 style='color:red;'>离开FirstFilter过滤器</h1>");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器FirstFilter,初始化");
		String filterName=filterConfig.getFilterName();//获取过滤器的名称
		String en=filterConfig.getInitParameter("encoding");//获取初始化参数
		String s=filterConfig.getInitParameter("isShuai");//获取初始化参数
		
		//获取ServletContext
		ServletContext application=filterConfig.getServletContext();
		System.out.println("过滤器的名称："+filterName);
		System.out.println("项目文件路径："+application.getRealPath(filterName));
		System.out.println("encoding:"+en);
		System.out.println("isshuai:"+s);
	}
	@Override
	public void destroy() {
		System.out.println("过滤器FirstFilter,销毁了");
		// TODO Auto-generated method stub
		
	}
}
