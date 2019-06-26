package com.igeek.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class SampleFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("SampleFilter1 销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("SampleFilter1  执行过滤");
		
		
		// 继续往下传递请求响应
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("SampleFilter1  初始化");
	}

}
