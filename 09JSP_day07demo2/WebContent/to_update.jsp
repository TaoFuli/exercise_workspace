<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tfl.service.*" %>
<%@ page import = "com.tfl.pojo.*" %>       
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户的修改</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
	
	<%
		//取得id
		String str_id = request.getParameter("id");
		if(str_id == null){
			response.sendRedirect("index.jsp");
			return;
		}
		
		//
		//调用业务对象
		UserService service  = new UserServiceImpl();
		User user = service.findById(Integer.parseInt(str_id));
	%>
	
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
					
					<ul class="nav navbar-nav navbar-right">
						
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">登录 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">登录</a>
								</li>
								<li>
									<a href="#">注册</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="#">退出</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- 顶部导航结束 -->
		
		
		
		<!-- 页面正文 -->
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h1>用户修改</h1>
					<form class="form-horizontal">
					 
					 <div class="form-group">
					    <label for="inputUserID" class="col-sm-2 control-label">编号</label>
					    <div class="col-sm-10">
					      <input type="text" readonly="readonly" class="form-control" id="inputUserID" value="<%=user.getId() %>" placeholder="编号">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputloginName" class="col-sm-2 control-label">登录名</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control"  value="<%=user.getLoginName() %>" id="inputloginName" placeholder="登录名">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputloginName" class="col-sm-2 control-label">姓名</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control"  value="<%=user.getUsername()%>" id="inputloginName" placeholder="姓名">
					    </div>
					  </div>
					 
					 <div class="form-group">
					    <label for="inputloginName" class="col-sm-2 control-label">生日</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="<%=user.getBirthday()%>" id="inputloginName" placeholder="生日">
					    </div>
					  </div>
					  
					  <div class="form-group">
					  	 <label for="inlineRadioOptions" class="col-sm-2 control-label">性别</label>
					  	<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" <%=("男".equals(user.getSex())?"checked":"")%>    id="inlineRadio1" value="男"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" <%=("女".equals(user.getSex())?"checked":"")%> id="inlineRadio2" value="女"> 女
						</label>
					  	
					  </div>
					  
					 
					 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					    <div class="col-sm-10">
					      <input type="email" class="form-control" value="<%=user.getEmail()%>"  id="inputEmail3" placeholder="邮箱">
					    </div>
					  </div>
					  
					  
					  <!--
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
					    </div>
					  </div>
					  -->
					  
					
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default">修改</button>
					    </div>
					  </div>
					</form>
					
				</div>				
			</div>
		</div>
		
	</body>
</html>
