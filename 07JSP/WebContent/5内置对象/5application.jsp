<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Integer count = (Integer)application.getAttribute("count");
	if(count==null) count=1;
	else count++;
	application.setAttribute("count", count);
	
	//out.println("在线人数:"+count);
%>
在线人数:<%= count %>
</body>
</html>