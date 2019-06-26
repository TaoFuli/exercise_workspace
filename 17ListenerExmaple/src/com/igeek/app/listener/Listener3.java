package com.igeek.app.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener3
 *
 */
@WebListener
public class Listener3 implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Listener3() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         
    	
    	System.out.println("Session 被销毁时,在线用户列表中移除用户");
    	// 从当前用户取出用户名
    	HttpSession session = se.getSession();    	
    	
    	String username = (String)session.getAttribute("username");
    	
    	// 得到ServletConext 
    	ServletContext sc = se.getSession().getServletContext();
    	// 取出在线用户列表
  		List<String> users = (List<String>)sc.getAttribute("users");
		// 从列表中移除用户
		users.remove(username);
		//　重新再存入
		sc.setAttribute("users", users);
    	
    	
    }
	
}
