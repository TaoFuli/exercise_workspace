<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("<h1>静夜思</h1>");
	out.println("<h1>静夜思</h1>");
	out.println("<h1>静夜思</h1>");
	
	// 缓冲区大小 8KB
	//out.flush();	// 立即清空, 立即将缓冲区的内容立即发给客户
	// 7888 8172
%>
缓冲区大小:<%= out.getBufferSize() %>
缓冲区剩余:<%= out.getRemaining() %>
是否自动清空:<%= out.isAutoFlush() %>
</body>
</html>