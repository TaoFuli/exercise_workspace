<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
		Cookie c1=new Cookie("username","igeekhome");
		Cookie c2=new Cookie("userid","10001");
		//发送到客户端
		response.addCookie(c1);
		response.addCookie(c2);
%>
</head>
<body>
		<h3>获取EL初始化参数</h3>
		<h3>encoding=${initParam.encoding}</h3>
		
		
		<h3>EL获取Cookie的值</h3>
		<h3>${cookie}</h3>
		<h3>${cookie.username.getValue()}</h3>
		<h3>${cookie.username.value}</h3>
		<h3>${cookie.userid.value}</h3>
		
		<h3>EL获取请求header信息</h3>
		<h3>${header}</h3>
		<h3>${header["accept-language"]}</h3>
		<h3>${header["host"]}</h3>
		<h3>${headerValues["user-agent"][0]}</h3>
</body>
</html>