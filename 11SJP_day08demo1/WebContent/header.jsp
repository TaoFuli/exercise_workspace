<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>代码留言板</title>
		<!-- 添加支持响应式布局的代码 -->
				<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
				<!--width=device-width 宽度是设备的宽度，initial-scale=1    出事的缩放比率
		shrink-to-fit=no 自动适应手机屏幕宽度  -->
				<!-- 1. 引入bootstrap css样式文件 -->
				<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
				<!-- 2. 导入jQuery -->
				<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
				<!-- 3. 导入popper 用于弹窗 提示、下拉框 -->
				<script type="text/javascript" src="./js/popper.min.js"></script>
				<!-- 4. 导入bootstrap js文件-->
				<script type="text/javascript" src="./js/bootstrap.min.js"></script>
				<!-- 5.导入jQuery的验证脚本 -->
				<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	</head>
<body>
	<!-- 顶部导航 -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
		<!-- 导航右边的四条杠,,,被覆盖的内容 -->
					<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
						<span class="sr-only">关于我们</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">代码留言</a>
				</div>
				
				<div class="collapse navbar-collapse" 
						id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="search">首页<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="">本站声明<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="">产品介绍<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="">新闻信息<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="">广告招商<span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="">关于我们<span class="sr-only">(current)</span></a>
						</li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<!-- 未登录时的用户下拉菜单 -->
						<c:if test="${empty CurrUser}">
							<li class="dropdown">
								<a href="" class="dropdown-toggle"
								data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">
									<!-- 用户图标 -->
									<span class="glyphicon glyphicon-user"></span>
									<!-- 插入符 -->
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="login.jsp">登录</a>
									</li>
									<li>
										<a href="register.jsp">注册</a>
									</li>
								</ul>
							</li>
						</c:if>
						<!-- 登录的菜单 -->
						<c:if test="${not empty CurrUser }">
							<li class="dropdown">
								<a href="" class="dropdown-toggle"
								data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">
									<span class="glyphicon glyphicon-user">
										${CurrUser.username }
									</span>
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="publish.jsp">发布留言</a>
									</li>
									<!-- 横线 -->
									<li role="separator" class="divider"></li>
									<li>
										<a href="loginout">注销</a>
									</li>
								</ul>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
		<!-- 顶部导航栏结束 -->
