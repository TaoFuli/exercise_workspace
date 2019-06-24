<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
		<script>
			// 找到表单，给表单添加验证的规则
			$(function() {
				$("#registerForm").validate({
					"rules": {
						"uloginName": {
							"required": true,
							"rangelength": [6, 12]
						},
						"username": {
							"required": true,
							"rangelength": [6, 12]
						},
						"password": {
							"required": true,
							"rangelength": [6, 12]
						},
						"comfirmpwd": {
							"required": true,
							"equalTo": "#password"
						},
						"usex": {
							"required": true
						},
						"ubirthday": {
							"required": true
						},
						"uemail": {
							"required": true,
							"email": true
						}
					},
					"messages": {
						"uloginName": {
							"required": "登录名必须填写",
							"rangelength": "登录名不合法"
						},
						"username": {
							"required": "用户名必须填写",
							"rangelength": "用户名不合法"
						},
						"password": {
							"required": "密码必须填写",
							"rangelength": "长度必须是在6-12为"
						},
						"comfirmpwd": {
							"required": "必须填写重复密码",
							"equalTo": "重复密码必须和密码一致"
						},
						"usex": {
							"required": "性别没选"
						},
						"ubirthday": {
							"required": "出生日期不能为空"
						},
						"uemail": {
							"required": "必须填写邮箱",
							"email": "邮箱格式不正确"
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
	<div class="col-md-offset-4">
		<form id="registerForm" action="register" method="post">
			<div class="col-md-12">
				<div class="col-md-4 col-md-offset-1">
					<h3>注册<small style="color:red;">${Err}</small></h3>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">登录名:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="text" name="uloginName" placeholder="请输入登录名" /></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">用户名:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="text" name="username" placeholder="请输入用户名" /></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">密码:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="password" name="password" placeholder="请输入密码" id="password" /></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">确认密码:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="password" name="comfirmpwd" placeholder="请输入确认密码" /></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">性别:</label>
				<div class="col-md-6">
					<input type="radio" name="usex" value="男" checked="checked" />男
					<input type="radio" name="usex" value="女"  />女
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">出生日期:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="date" name="ubirthday" style="color:#000;"/></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">Email:</label>
				<div class="col-md-6">
					<abbr style="color:red;"><input type="email" name="uemail" placeholder="Email" /></abbr>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-2 text-right">验证码:</label>
				<div class="col-md-1 text-left">
					<abbr style="color:red;"><input type="text" name="checkCode" style="width:80px;" /></abbr>
				</div>
				<div class="text-left">
					<img src='checkImage' id='checkImg' style="margin-left:20px;"/>
					<script>
						document.getElementById('checkImg').onclick = function() {
						var r = Math.random();
						this.src = 'checkImage?' + r;
						};
					</script>
				</div>
			</div>
			<div class="form-group row"><br />
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<input type="submit" value="注册" style="width:100px;height:35px;background-color:lightgoldenrodyellow;" />
				</div>
			</div>
		</form>
	</div>
		
		<%@ include file="footer.jsp" %>