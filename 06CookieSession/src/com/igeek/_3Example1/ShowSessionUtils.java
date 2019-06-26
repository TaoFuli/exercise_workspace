package com.igeek._3Example1;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowSessionUtils {

	public static void showSessionInfo(HttpServletRequest req,PrintWriter pw)
	{
		pw.println("<h1>会话信息</h1>");
		HttpSession s = req.getSession();
		s.setMaxInactiveInterval(30);
		if(s.isNew())
		{
			pw.println("新的会话</br>");
		}
		else
		{
			pw.println("老的会话</br>");
		}
		pw.println("会话的编号:"+s.getId()+"<br />");
		pw.println("会话的创建的时间:"+s.getCreationTime()+"<br />");
		pw.println("会话的最后访问时间:"+s.getLastAccessedTime()+"<br />");
		pw.println("会话的最大不活动时间:"+s.getMaxInactiveInterval()+"<br />");
		pw.println("<br />");
	}
}
