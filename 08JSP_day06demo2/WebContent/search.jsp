<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tfl.dao.*" %>
    <%@ page import="com.tfl.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
</head>
<body>
<%
		if(session.getAttribute("CurrUser")==null)
		{
			response.sendRedirect("login.jsp");
		}
%>
<%@ include file="head.jsp" %>  <!-- 顶部导航 -->
<h2>查询</h2>
<form action="search.jsp" method="get">
<input type="text" name="queryString" placeholder="请输入查询的用户名" />
<button>Search</button>
</form>
<br />
<%
		String qs=request.getParameter("queryString");
		if(qs==null)
		{
			qs="";
		} 
		UserDao dao=new UserDaoImpl();
		List<User> users=dao.selectByUserName(qs);
		
		for(User u:users)
		{
			out.println(u+"<br>");
		}
%>

</body>
</html>