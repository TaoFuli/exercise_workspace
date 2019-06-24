<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tfl.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航栏</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</head>
<body>
<body>
		<!-- 顶部的导航  -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
					<a class="navbar-brand" href="#">极客营</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#">首页 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="#">关于我们</a>
						</li>
					</ul>
<%
		User user=null;
		user=(User)session.getAttribute("CurrUser");
		if(user!=null){
%>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							<%=user.getUsername()+","%>登录 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#" >><%=user.getUsername()+",已经"%>登录</a>
								</li>
								<li>
									<a href= <%=(user!=null)?"edit.jsp":"login.jsp"%> >个人信息</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="loginout.jsp">退出</a>
								</li>
							</ul>
						</li>
					</ul>
					<%} %>
				</div>
			</div>
		</nav>
</body>
</html>