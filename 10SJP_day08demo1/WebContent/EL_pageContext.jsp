<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>打印获取EL的内置对象pageContext信息</title>
</head>
<body>

<h3>EL的内置对象pageContext可以获取当前页面中所有的JSP的内置对象</h3>
<h3>request=${pageContext.request}</h3>
	<h3>response=${pageContext.response}</h3>
	<h3>session=${pageContext.session}</h3>
	<h3>application=${pageContext.servletContext}</h3>
	<h3>config=${pageContext.servletConfig}</h3>
	<hr>
	<h2>当前工程的上下文路径：<%=request.getContextPath() %></h2>
	<h3>客户端的ip:<%=request.getRemoteHost() %></h3>
	<h3>客户端的port:<%=request.getRemotePort() %></h3>
	
	<h3>服务器的ip:<%=request.getLocalAddr() %></h3>
	<h3>服务器的端口：<%=request.getLocalPort() %></h3>
	
	<h3>请求的URL:<%=request.getRequestURL() %></h3>
	<h3>请求的URI:<%=request.getRequestURI() %></h3>
	<H3>请求的协议：<%=request.getScheme() %></H3>
	
	<hr>
	<h3>服务器的绝对路径：<%=request.getScheme()+"://"+request.getLocalAddr()
						+":"+request.getLocalPort()+request.getContextPath()
						+"/EL+pageContext.jsp"%></h3>


</body>
</html>