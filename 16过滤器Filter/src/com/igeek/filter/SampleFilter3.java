package com.igeek.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//参考: https://blog.csdn.net/mytt_10566/article/details/70214640
@WebFilter(
		filterName="/Filter3",
		urlPatterns= {"/admin/*"},
		initParams= {
				@WebInitParam(name="paramA",value="aaa"),
				@WebInitParam(name="paramB",value="bbb"),
		}
		)
public class SampleFilter3 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("SampleFilter3销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("SampleFilter3 执行过滤");
		
		
		// 继续往下传递请求响应
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("SampleFilter3 初始化");
		
		System.out.println("参数:"+filterConfig.getInitParameter("param1"));
		
	}

}