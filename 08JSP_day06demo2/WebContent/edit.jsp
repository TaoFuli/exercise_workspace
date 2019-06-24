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
<title>Insert title here</title>
</head>
<body>
<%@ include file="head.jsp" %>  <!-- 顶部导航 -->
<div class="container">
	<form action="login.jsp" method="post">
		<table border="1" style="background-color:#FAFFBD;">
			<tr>
				<td colspan="2" style="text-align:cent;"><h2>修改页面</h2></td>
			</tr>
			
			<tr>
				<td style="text-align:right;">用户名：</td>
				<td>
					<input type="text" name="username" value=<%=user.getUsername() %> />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">账户名：</td>
				<td>
					<input type="tel"  name="loginName" value=<%=user.getLoginName() %> />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">密码：</td>
				<td>
					<input type="password" name="password" value=<%=user.getPassword() %> />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">性别：</td>
				<td>
					<input type="radio" name="sex" <%=("男".equals(user.getSex())?"checked":"")%>  value="男"/>男
		    		<input type="radio" name="sex" <%=("女".equals(user.getSex())?"checked":"")%> value="女" />女
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;">生日：</td>
		    	<td>
		    		<input type="date" name="birthday" value=<%=user.getBirthday() %> />
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;">email:</td>
		    	<td>
		    		<input type="email" name="email" value=<%=user.getEmail() %>/>
		    	</td>
		    </tr>
		    <tr>
		    	<td style="text-align:right;"></td>
		    	<td><button style="background-color:#9D9D9D;">修改</button></td>
		    </tr>
		</table>
	</form>
</div>
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
				User tmp=user;
				if(dao.removeByLoginName(user)>0){
					dao.insertByUser(tmp);
					out.println("<script>confirm('修改成功!');</script>");
					/* response.sendRedirect("login.jsp"); */
				}
				else
				{
					out.println("<script>confirm('修改失败!请重试');</script>");
					/* response.sendRedirect("register.jsp"); */
				}
			}


%>
</body>
</html>