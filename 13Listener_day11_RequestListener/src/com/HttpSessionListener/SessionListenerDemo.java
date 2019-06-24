package com.HttpSessionListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerDemo
 *
 */
@WebListener
public class SessionListenerDemo implements HttpSessionListener, HttpSessionAttributeListener {
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	String sessionId=se.getSession().getId();
    	System.out.println("会话创建了："+sessionId);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("会话销毁了："+se.getSession().getId());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent hsbe)  { 
         // TODO Auto-generated method stub
    	System.out.println("会话作用域变量："+hsbe.getName()+"创建了，值是"+hsbe.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent hsbe)  { 
         // TODO Auto-generated method stub
    	System.out.println("会话作用域变量："+hsbe.getName()+"移除了，值是"+hsbe.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent hsbe)  { 
         // TODO Auto-generated method stub
    	System.out.println("会话作用域变量"+hsbe.getName()+"修改了，修改前的值为："+hsbe.getValue());
    }
	
}
