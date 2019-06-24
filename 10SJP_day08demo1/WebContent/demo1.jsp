<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式的基本使用</title>
</head>
<body>
<%
		//四个作用域：page,request,session.application
		pageContext.setAttribute("num1", 10);
		request.setAttribute("num1", 20);
		session.setAttribute("num1", 30);
		application.setAttribute("num1",40);
		
		request.setAttribute("name", "字符");
%>
<h1>
<%=(Integer)pageContext.getAttribute("num1")
	+(Integer)request.getAttribute("num1")
	+(Integer)session.getAttribute("num1")
	+(Integer)application.getAttribute("num1")
%>
</h1>

<%--
		EL 表达式语法：${el表达式}
		内置对象取得四个作用域的值：
		pageScope
		requestScope
		sessionScope
		applicationScope
		
		取值可以使用    .变量名    号或者["变量名"]
		取得page作用域中的num1,EL表达式  ${pageScope.null}或
								 ${pageScope["num1"]}
 --%>
<h1>
		${pageScope.num1+requestScope.num1+sessionScope.num1+applicationScope.num1}
</h1>
	<!-- 不指定作用域，直接取得num1
			会依次查找：page,request.session.application 中的变量，找到就返回值
			等同于
			pageContext.findAttribute("num1");
	-->
<h1>${name}</h1>
<h1><%=pageContext.findAttribute("name") %></h1>
<h1>${10+20+20}</h1>

</body>
</html>