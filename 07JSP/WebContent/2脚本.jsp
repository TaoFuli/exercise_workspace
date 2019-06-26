<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. 脚本</h1>
<%
	// 写任何Java代码
	if(Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM)
	{
		out.println("上午好");
	}
	else
	{
		out.println("下午好");
	}

%>

<h1>2. 声明变量</h1>
<%! int x; // 会被定义为Servlet成员变量  %>
<%
	out.println("访问计数"+(x++));

	int y =0; // 局部变量
	out.println("访问计数"+(y++));
	
	y=20;
%>

<h1>3. 表达式</h1>
x = <%= x %><br />
y = <%= y %><br />
x+y=<%=x+y %><br />

</body>
</html>