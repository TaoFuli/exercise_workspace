<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 引入头部信息 -->
<%@ include file="header.jsp" %>

	<script>
			// 找到表单，给表单添加验证的规则
			$(function() {
				$("#loginForm").validate({
					"rules": {
						"username": {
							"required": true,
							"rangelength": [6, 12]
						},
						"password": {
							"required": true,
							"rangelength": [6, 12]
						}
					},
					"messages": {
						"username": {
							"required": "用户名必须填写",
							"rangelength": "用户名不合法"
						},
						"password": {
							"required": "密码必须填写",
							"rangelength": "长度必须是在6-12为"
						}
					},
					errorPlacement: function(error, element) { //指定错误信息位置
						if(element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
							//var eid = element.attr('name'); //获取元素的name属性
							error.appendTo(element.parent()); //将错误信息添加当前元素的父结点后面
						} else {
							error.insertAfter(element);
						}
					}
				});

			});
		</script>
	<!-- 登录面板 -->
<div class="container" style="height:400px;width:900px; background-color:#E1EED2;">
	<div class="row">
		<div class="col-md-5 col-md-offset-4">
			<h2 style="font-weight: bolder;">用户登录<small style="color:red;">${Err}</small></h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form id="loginForm" action='login' method='get'>
				<label class="col-sm-3" for="Inputname">账&nbsp;&nbsp;&nbsp;号：</label>
				<div class="col-sm-9">
					<abbr style="color:red;">
						<input type='text' class="form-control form-group" id="Inputname"
						 name='username' placeholder="请输入登录名" />
					 </abbr>
				 </div>
				<label class="col-sm-3" for="Inputpwd">密&nbsp;&nbsp;&nbsp;码：</label>
				<div class=" col-sm-9">
					<abbr style="color:red;">
						<input type='password' class="form-control form-group" id="Inputpwd"
						 name='password' placeholder="请输入登录密码"/>
					 </abbr>
				 </div>
				<label class="col-sm-4" for="Inputpwd">验证码：</label>
				<div class="col-sm-8" style="margin-left:-22px">
					<input type='text' class="form-control form-group col-sm-3" style="width:70px;margin-right:5px;"
					 name='checkCode' />
					<img src='checkImage' id='checkImg' style="width:70px;height:30px;"/>
						<script>
							document.getElementById('checkImg').onclick=function(){                     
							var r=Math.random();                                                        
							this.src='checkImage?'+r;                                                   
							};                                                                          
		  				</script>
	  			</div>
	  			<div class="row" style="padding-bottom:10px;">
					<input type='submit' class="btn btn-primary" value='登录' style="margin-left:100px;"/>
					<input type='button' onclick="window.open('register.jsp')"
						name='register' class="btn btn-primary" value='注册' />
				</div>
		</form>
		</div> 
	</div>
</div>
		
<!-- 足部信息 -->
<%@ include file="footer.jsp" %>