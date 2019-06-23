package com.tfl.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tfl.service.MessageService;

@WebListener
public class SpringUtilsListener  implements  ServletContextListener{

	/**
	 * 当前web应用启动 触发
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext  application = sce.getServletContext();
		
		WebApplicationContext applicationContext =WebApplicationContextUtils.
				getWebApplicationContext(application);
		
		MessageService  service = applicationContext.getBean(MessageService.class);
		
		//存入Servlet上下文对象中  共享
		application.setAttribute("service", service);
	}
	
	
	/**
	 * 当前web应用关闭 触发
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
