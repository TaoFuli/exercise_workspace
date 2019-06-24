package _2Session;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

public class ShowSessionUtils
{
	public static void showSessionInfo(HttpSession session,PrintWriter pw)
	{
		pw.println("<h1>会话信息</h1>");
		
		session.setMaxInactiveInterval(20);
		if(session.isNew())
		{
			pw.println("<br />新的会话");
		}
		else
		{
			pw.println("<br />老的会话");
		}
		pw.println("<br />会话的编号:"+session.getId());
		pw.println("<br />会话的创建时间:"+session.getCreationTime());
		pw.println("<br />会话的最后访问时间:"+session.getLastAccessedTime());
		pw.println("<br />会话的最大不活动时间:"+session.getMaxInactiveInterval());
		
		pw.println("<hr />");
		
	}

}
