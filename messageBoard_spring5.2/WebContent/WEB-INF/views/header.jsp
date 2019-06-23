<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>极客50营留言板</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>

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
					<a class="navbar-brand" href="#">极客50营</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="index">首页 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="#">关于我们</a>
						</li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						
						<!-- 未登录的菜单 -->
						<c:if test="${empty CurrUser}">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
									<span class="glyphicon glyphicon-user"></span>
									 <span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="login">登录</a>
									</li>
									<li>
										<a href="reg">注册</a>
									</li>
								</ul>
							</li>
						</c:if>
						
						<!-- 登录的菜单 -->
						<c:if test="${not empty CurrUser}">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
									<span class="glyphicon glyphicon-user"></span>
									${CurrUser.username}
									 <span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="publish">发布留言</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="logout">注销</a>
									</li>
								</ul>
							</li>
						</c:if>
						
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- 顶部导航结束 -->
		
  
