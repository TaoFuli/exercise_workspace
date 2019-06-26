<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("x", 10);
	pageContext.setAttribute("y", 20);
	
	pageContext.setAttribute("a",true);
	pageContext.setAttribute("b",false);
%>
<h1>1. 算术运算</h1>
<h3>${x+y}</h3>
<h3>${x-y}</h3>
<h3>${x*y}</h3>
<h3>${x/y}</h3>
<h3>${x%y}</h3>

<h1>2. 关系运算符</h1>
<h3>${x>y}</h3>

<h1>3. 逻辑运算符</h1>
<h3>${a&&b}</h3>

<h1>4. 判断为空</h1>
<h3>${empty a}</h3>
<h3>${empty c}</h3>

</body>
</html>