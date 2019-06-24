<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tfl.dao.*" %>
    <%@ page import="com.tfl.pojo.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<%@ include file="head.jsp" %>  <!-- 顶部导航 -->
<div class="container">
	<form action="register.jsp" method="post">
		<table border="1" style="background-color:#FAFFBD;">
			<tr>
				<td colspan="2" style="text-align:cent;"><h2>注册页面</h2></td>
			</tr>
			
			<tr>
				<td style="text-align:right;">用户名：</td>
				<td>
					<input type="text" name="username" placeholder="请输入用户名" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">账户名：</td>
				<td>
					<input type="text" name="loginName" placeholder="请输入登录名" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">密码：</td>
				<td>
					<input type="password" name="password" placeholder="请输入密码" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">性别：</td>
				<td>
					<input type="radio" name="sex" checked="checked" value="男"/>男
		    		<input type="radio" name="sex" value="女" />女
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;">生日：</td>
		    	<td>
		    		<input type="date" name="birthday" />
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;">email:</td>
		    	<td>
		    		<input type="email" name="email" />
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;"></td>
		    	<td><button style="background-color:#9D9D9D;">立即注册</button></td>
		    </tr>
		</table>
	</form>
<%
		if(request.getMethod().equalsIgnoreCase("POST")){
			request.setCharacterEncoding("UTF-8");
			UserDao dao=new UserDaoImpl();
		
			String username=request.getParameter("username");
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			String sex=request.getParameter("sex");
			String birthday=request.getParameter("birthday");
			String email=request.getParameter("email");
			user.setUsername(username);
			user.setLoginName(loginName);
			user.setPassword(password);
			user.setSex(sex);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birthday).toString());
			user.setEmail(email);
			if(dao.insertByUser(user)>0){
				out.println("<script>confirm('注册成功!');</script>");
				/* response.sendRedirect("login.jsp"); */
			}
			else
			{
				out.println("<script>confirm('注册失败!请重新注册.');</script>");
				/* response.sendRedirect("register.jsp"); */
			}
		}
	
	%>
















</div>
</body>
</html>