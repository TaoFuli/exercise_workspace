<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tfl.pojo.*" %>

<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>极客营50营聊天室-发送信息</title>
	</head>
	
	<%!
	/** 替换 <> */
	  String  changeHTML(String s){
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		
		return s;
	}
	
	%>
	
	
	<%
		//判断提交
		if("POST".equalsIgnoreCase(request.getMethod())){
			//设置编码
			request.setCharacterEncoding("UTF-8");
			
			//接收表单参数
			String to = request.getParameter("to");
			String message = request.getParameter("message");
			String font = request.getParameter("font");
			String color = request.getParameter("color");
			String fontSize = request.getParameter("fontSize");
			
			String from = (String)session.getAttribute("CurrUser");
			
			message = changeHTML(message);
			
			//封装Message
			Message m = new Message(to,from,message,font,color,fontSize);
			
			//添加到聊天信息的集合中
			List<Message> messages = (List<Message>)application.getAttribute("Messages");
			if(messages == null){
				messages = new ArrayList<>();
				application.setAttribute("Messages",messages);
			}
			
			//存入聊天的集合
			messages.add(m);
			
			//重定向到自己
			response.sendRedirect("send.jsp");
		}
	
	
	
	
	
	
		//取得在线人员列表
		List<String> onlineUsers = (List<String>)application.getAttribute("OnLines");
	%>
	
	<body>
		<div style="text-align: left;">
			<form method="post">
				选择说话对象:
				<select name="to">
					<option value="大家">大家</option>
					
					<%
					  if(onlineUsers != null){
						  for(String u : onlineUsers){
							  out.println("<option value="+u+">"+u+"</option>");
						  }
					}
					%>
				</select>
				
				选择字体:
				<select name="font">
					<option value="宋体">宋体</option>
					<option value="隶属">隶属</option>
					<option value="楷体">楷体</option>
					<option value="华文行楷">华文行楷</option>
				</select>
				
				字体颜色:
				<select name="color">
					<option value="#000000">黑色</option>
					<option value="#FF0000">红色</option>
					<option value="#00FF00">绿色</option>
					<option value="#0000FF">蓝色</option>
					<option value="#00FFFF">黄色</option>
				</select>
				字体大小:
				<select name="fontSize">
					<option value="12px">正常</option>
					<option value="36px">大</option>
					<option value="10px">小</option>
				</select>
				
				
				<br/>
				聊天内容:
				<input type="text" name="message" /><button>发送</button>
			</form>
		</div>
	</body>
</html>
