package com.igeek.app.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener2 implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public Listener2() {
        // TODO Auto-generated constructor stub
    	
    	System.out.println("Listener2()");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
        
    	System.out.println("HttpSession 有属性被添加"+arg0.getName()+":"+arg0.getValue());
    	
    	
    	HttpSession session = arg0.getSession();
    	
    	if(arg0.getName().equals("username"))
    	{

    		String username = (String)arg0.getValue();
    				
    		// 得到ServletContext
    		ServletContext sc = arg0.getSession().getServletContext();
    		// 取出在线用户列表
    		List<String> users = (List<String>)sc.getAttribute("users");
    		// 把当前用户放入
    		users.add(username);
    		//　重新再存入
    		sc.setAttribute("users", users);
    	}
    	
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  
    { 
    	
    	
    	System.out.println("HttpSession 有属性被替换"+arg0.getName()+":"+arg0.getValue());
    	System.out.println(arg0.getSession().getAttribute(arg0.getName()));
    	
    	
    	HttpSession session = arg0.getSession();
    	
    	if(arg0.getName().equals("username"))
    	{

    		String oldUsername = (String)arg0.getValue();
    		String username = (String)session.getAttribute(arg0.getName());
    				
    		// 得到ServletContext
    		ServletContext sc = arg0.getSession().getServletContext();
    		// 取出在线用户列表
    		List<String> users = (List<String>)sc.getAttribute("users");
    		// 把当前用户放入
    		users.remove(oldUsername);
    		users.add(username);
    		//　重新再存入
    		sc.setAttribute("users", users);
    	}
    }
	
}
