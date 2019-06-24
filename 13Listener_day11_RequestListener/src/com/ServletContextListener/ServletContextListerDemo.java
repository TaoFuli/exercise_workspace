package com.ServletContextListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListerDemo
 *
 */
@WebListener
public class ServletContextListerDemo implements ServletContextListener, ServletContextAttributeListener {


	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    	String varName=event.getName();
    	Object varValue=event.getValue();
    	System.out.println("application作用域变量："+varName+"创建了，值是："+varValue);
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    	String varName=event.getName();
    	Object varValue=event.getValue();
    	System.out.println("application作用域变量："+varName+"删除了，值是"+varValue);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	String path=sce.getServletContext().getContextPath();
    	System.out.println("关闭了："+path);
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    	String varName=event.getName();
    	Object varValue=event.getValue();
    	System.out.println("application作用域变量："+varName+"修改了，修改前的值为"+varValue);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	String path=sce.getServletContext().getContextPath();
    	System.out.println("启动了："+path);
    }
	
}
