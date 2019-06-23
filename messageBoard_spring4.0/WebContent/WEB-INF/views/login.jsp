<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>



<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<h2>用户登录</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<span>${Err }</span>
			<form action="login" method="post">
			 	<div class="form-group">
			    	<label for="Inputname">用户名</label>
			    	<input type="text" class="form-control" id="Inputname" name="name" placeholder="请输入登录名">
			  	</div>
			 	<div class="form-group">
			    	<label for="Inputpwd">密码</label>
			    	<input type="password" class="form-control" id="Inputpwd" name="pwd" placeholder="请输入密码">
			  	</div>
			  	<button type="submit" class="btn btn-info">登录</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>