package com.tfl;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {
	private ServletContext application;
	@Override 
	public void sessionCreated(HttpSessionEvent arg0) {
		Integer i=(Integer)application.getAttribute("OnLineCount");
		application.setAttribute("OnLineCount",(i+1));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		Integer i=(Integer) application.getAttribute("OnLineCount");
		application.setAttribute("OnLineCount", (i-1));
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		application=sce.getServletContext();
		//添加一个变量进行当前会话数量统计
		application.setAttribute("OnLineCount", 0);
		//实例化Timer
		Timer timer=new Timer();		//任务调度
		timer.schedule(new TimerTask() {
			//开启   任务调度   延迟1秒后执行
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("我喜欢你的袜子");
				//结束任务
				// timer.cancel();
			}
		}, 0,1000);
	}

}
