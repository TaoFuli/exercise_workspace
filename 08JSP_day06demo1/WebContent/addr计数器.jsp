<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IP 计数器</title>
</head>
<body>
<%
	ArrayList<String> AllClientIP=(ArrayList<String>)application.getAttribute("AllClientIP");
	if(AllClientIP==null){
		AllClientIP=new ArrayList<>();
		application.setAttribute("AllClientIP",AllClientIP);
	}
	Object obj=application.getAttribute("count");
	Integer inte=(Integer)obj;
	String client=request.getRemoteHost();
	
	if(inte==null){
		inte=1;
		session.setAttribute("me", inte);
		AllClientIP.add(client);
	}
	else
	{
		if(session.isNew())
		{
			inte++;
			session.setAttribute("me",inte);
			AllClientIP.add(client);
		}
	}
	application.setAttribute("count",inte);
%>
<h1>当前在线人数：<%=application.getAttribute("count") %>人。
你是第<%=session.getAttribute("me") %>位访问的。

<%
		for(String ip:AllClientIP)
		{
			out.println("<h3>"+ip+"</h3>");
		}
%>
</h1>
</body>
</html>