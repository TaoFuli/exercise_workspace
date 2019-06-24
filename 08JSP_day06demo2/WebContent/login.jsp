<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.tfl.pojo.*" %>
    <%@ page import="com.tfl.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>

<%
		User user=(User)session.getAttribute("CurrUser");
		if(user==null){
%>

	<form action="login.jsp" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="loginName" placeholder="请输入用户名" />
				</td>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password" placeholder="请输入密码" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><button>登录</button></td>
			</tr>
		</table>
	</form>
<%
		}else{
			 out.println("<a href='search.jsp'>查询</a>");
			}
		if(request.getMethod().equalsIgnoreCase("POST"))
		{
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			UserDao dao=new UserDaoImpl();
			
			User uu=dao.selectByLoginNameAndPassword(loginName,password);
			if(uu==null)
			{
				out.println("<h2>登录失败！请重新登录！</h2>");
			}
			else
			{
				session.setAttribute("CurrUser",uu);
				response.sendRedirect("search.jsp");
			}
		}
%>
</body>
</html>