<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate();
Cookie c1 = new Cookie("username","");
Cookie c2 = new Cookie("password","");
c1.setMaxAge(0);
c2.setMaxAge(0);
c1.setPath("/");
c2.setPath("/");
response.addCookie(c1);
response.addCookie(c2);
%>

<a href="login.jsp">登录页面</a>
<a href="main.jsp">首页</a>

</body>
</html>