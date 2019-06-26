<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	application.setAttribute("x", "application域对象作用范围");
	session.setAttribute("x", "session域对象作用范围");
	request.setAttribute("x", "request域对象作用范围");
	pageContext.setAttribute("x", "page域对象作用范围");
	
	// 如果与对象中有相同的属性名 则按照从小到大范围查找
%>

${x}<br />
${pageScope.x}<br />
${requestScope.x}<br />
${sessionScope.x}<br />
${applicationScope.x}

</body>
</html>