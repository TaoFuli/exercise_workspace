<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Cookie c=new Cookie("centerName","niit");
response.addCookie(c);
%>

<h1>会话ID:${cookie.JSESSIONID.value}</h1>
<h1>cookie中key为centerName的值为:${cookie.centerName.value}</h1>

</body>
</html>