package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tfl.service.MessageService;

/**
 * 
 * 控制器
 * @author 极客营
 * @date 2018年10月19日
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//业务
	private  MessageService service;
	
	private int pageSize = 3;
	
	/**
	 * 初始化方法
	 */
	@Override
	public void init() throws ServletException {
		WebApplicationContext applicationContext =WebApplicationContextUtils.
				getWebApplicationContext(this.getServletContext());
		service = applicationContext.getBean(MessageService.class);
	}
	
	
	/**
	 * 处理Get请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接受页码
		int currPage  = 1;
		try {
			currPage = Integer.parseInt(request.getParameter("p"));
		}catch(Exception e) {}
		
		
		//1  每次获取的都是一个 spring 容器
		/*ApplicationContext applicationContext =
		(ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		System.out.println("applicationContext:"+applicationContext);*/
		
		//2 使用spring提供  WebApplicationContext
		/*WebApplicationContext applicationContext =WebApplicationContextUtils.
				getWebApplicationContext(this.getServletContext());*/
		
		
		//调用业务
		request.setAttribute("paging",service.search(pageSize, currPage));
		
		//转发
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		
	}

}
