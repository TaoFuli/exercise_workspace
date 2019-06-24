<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.tfl.service.*" %>
<%@ page import = "com.tfl.pojo.*" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户查询</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>

	<%
		//判断是不是表单提交
		if("POST".equalsIgnoreCase(request.getMethod())){
			//设置请求编码
			request.setCharacterEncoding("UTF-8");
			//获取表单对象
			String queryString = request.getParameter("queryString");
			
			//调用业务对象
			UserService service  = new UserServiceImpl();
			List<User> userlist = service.findByName(queryString);
			//存储到作用域
			request.setAttribute("UserList", userlist);
		}
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
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<form action="#" method="post">
						<div class="input-group">
					      <input type="text" class="form-control" name="queryString"  placeholder="请输入搜索的名称">
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="submit">Search</button>
					      </span>
					    </div><!-- /input-group -->
				    </form>
				</div>
			</div>	
			
			
			<div class="row">
				<div class="col-md-12">
					<%
					 //从作用域取得
					  List<User> userlist = (List<User>)request.getAttribute("UserList");
					if(userlist != null ){
					%>
					<table class="table table-hover">
						
						<thead>
							 <tr>
							   	<td>编号</td>	
							   	<td>姓名</td>	
							   	<td>登录名</td>
							   	<td>性别</td>	
							   	<td>生日</td>
							   	<td>邮箱</td>
							   	<td>操作</td>	
							   </tr>
						</thead>
						<tbody>
							<%
								for(User user : userlist){
							%>
							 <tr>
							   	<td><%=user.getId() %></td>	
							   	<td><%=user.getUsername() %></td>	
							   	<td><%=user.getLoginName()%></td>
							   	<td><%=user.getSex()%></td>	
							   	<td><%=user.getBirthday() %></td>
							   	<td><%=user.getEmail() %></td>
							   	<td>
							   		<a href="to_update.jsp?id=<%=user.getId() %>">修改</a>
							   		|
							   		<a href="do_delete.jsp?id=<%=user.getId() %>">删除</a>
							   	</td>	
							  </tr>
						<%}%> 
							  <!-- <tr>
							   	<td>1001</td>	
							   	<td>张三</td>	
							   	<td>san</td>
							   	<td>男</td>	
							   	<td>2018-1-1</td>
							   	<td>san@igeekhome.com</td>
							   	<td>
							   		<a href="#">修改</a>
							   		|
							   		<a href="#">删除</a>
							   	</td>	
							  </tr> -->
						</tbody>
					  
					</table>
					
					<%} %>
				</div>
			</div>
			
			
		</div>
		
		
		
		
	</body>

</html>