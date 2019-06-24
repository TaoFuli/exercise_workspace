<%@page import="java.net.URLEncoder"%>
<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>极客营50营聊天室-登录</title>
	</head>
	
	<%
		//判断是不是登录
		if("POST".equalsIgnoreCase(request.getMethod())){
			//设置编码
			request.setCharacterEncoding("UTF-8");
			
			//接收表单参数
			String nickName = request.getParameter("nickName");
			
			
			
			//存入在线人员列表
			List<String> onlineUsers = (List<String>)application.getAttribute("OnLines");
			if(onlineUsers==null){
				onlineUsers = new ArrayList<>();
				application.setAttribute("OnLines",onlineUsers);
			}
			
			//检测是不是重名
			if(onlineUsers.contains(nickName)){
				
				String  s = URLEncoder.encode("用户名重复了，亲换一个!", "UTF-8");
				
				//重定向
				response.sendRedirect("index.jsp?err="+s);
				return;
			}
			
			//存入会话
			session.setAttribute("CurrUser", nickName);
			
			
			//添加登录的用户
			onlineUsers.add(nickName);
			
			//重定向
			response.sendRedirect("main.jsp");
		}
	%>
	
	
	<body>
		<div style="margin-top: 200px;text-align: center;">
			<h1>极客营50营聊天室-登录</h1>
			<h1 style="color:REd;">
				<%=request.getParameter("err")==null?"":request.getParameter("err") %>
			</h1>
			<form action="#" method="post">
				请输入昵称:<input type="text" name="nickName" /><button>进入聊天室</button>
			</form>
		</div>
	</body>
</html>
