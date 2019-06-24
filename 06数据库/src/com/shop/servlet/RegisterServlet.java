package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		
		
		pw.println("<!DOCTYPE html>                                                                                                   ");
		pw.println("<html>                                                                                                            ");
		pw.println("	<head>                                                                                                        ");
		pw.println("		<meta charset='UTF-8'>                                                                                    ");
		pw.println("		<title>注册</title>                                                                                       ");
		pw.println("		<!-- 添加支持响应式布局的代码 -->                                                                         ");
		pw.println("		<meta name='viewport' content='width=device-width, initial-scale=1,shrink-to-fit=no'>                     ");
		pw.println("		<!--                                                                                                      ");
		pw.println("			width=device-width 宽度是设备的宽度                                                                   ");
		pw.println("			initial-scale=1    出事的缩放比率                                                                     ");
		pw.println("			shrink-to-fit=no 自动适应手机屏幕宽度                                                                 ");
		pw.println("        -->                                                                                                       ");
		pw.println("		<!-- 1. 引入bootstrap 样式文件 -->                                                                        ");
		pw.println("		<link rel='stylesheet' type='text/css' href='./css/bootstrap.min.css' />                                  ");
		pw.println("		<!-- 2. 导入jQuery -->                                                                                    ");
		pw.println("		<script type='text/javascript' src='./js/jquery-3.3.1.min.js'></script>                                   ");
		pw.println("		<!-- 3. 导入popper 用于弹窗 提示、下拉框 -->                                                              ");
		pw.println("		<script type='text/javascript' src='./js/popper.min.js'></script>                                         ");
		pw.println("		<!-- 4. 导入bootstrap js文件-->                                                                           ");
		pw.println("		<script type='text/javascript' src='./js/bootstrap.min.js'></script>                                      ");
		pw.println("		<!-- 5.导入jQuery的验证脚本 -->                                                                           ");
		pw.println("		<script type='text/javascript' src='js/jquery.validate.min.js'></script>                          ");
		pw.println("		<script>                                                                                          ");
		pw.println("			// 找到表单，给表单添加验证的规则                                                             ");
		pw.println("			$(function() {                                                                                ");
		pw.println("				$('#registerForm').validate({                                                             ");
		pw.println("					'rules': {                                                                            ");
		pw.println("						'username': {                                                                     ");
		pw.println("							'required': true,                                                             ");
		pw.println("							'rangelength': [6, 12]                                                        ");
		pw.println("						},                                                                                ");
		pw.println("						'password': {                                                                     ");
		pw.println("							'required': true,                                                             ");
		pw.println("							'rangelength': [6, 12]                                                        ");
		pw.println("						},                                                                                ");
		pw.println("						'comfirmpwd': {                                                                   ");
		pw.println("							'required': true,                                                             ");
		pw.println("							'equalTo': '#password'                                                        ");
		pw.println("						},                                                                                ");
		pw.println("						'email': {                                                                        ");
		pw.println("							'required': true,                                                             ");
		pw.println("							'email': true                                                                 ");
		pw.println("						}                                                                                 ");
		pw.println("					},                                                                                    ");
		pw.println("					'messages': {                                                                         ");
		pw.println("						'username': {                                                                     ");
		pw.println("							'required': '用户名必须填写',                                                 ");
		pw.println("							'rangelength': '用户名不合法'                                                 ");
		pw.println("						},                                                                                ");
		pw.println("						'password': {                                                                     ");
		pw.println("							'required': '密码必须填写',                                                   ");
		pw.println("							'rangelength': '长度必须是在6-12为'                                           ");
		pw.println("						},                                                                                ");
		pw.println("						'comfirmpwd': {                                                                   ");
		pw.println("							'required': '必须填写重复密码',                                               ");
		pw.println("							'equalTo': '重复密码必须和密码一致'                                           ");
		pw.println("						},                                                                                ");
		pw.println("						'email': {                                                                        ");
		pw.println("							'required': '必须填写邮箱',                                                   ");
		pw.println("							'email': '邮箱格式不正确'                                                     ");
		pw.println("						}                                                                                 ");
		pw.println("					},                                                                                    ");
		pw.println("					errorPlacement: function(error, element) { //指定错误信息位置                         ");
		pw.println("						if(element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox     ");
		pw.println("							//var eid = element.attr('name'); //获取元素的name属性                        ");
		pw.println("							error.appendTo(element.parent()); //将错误信息添加当前元素的父结点后面        ");
		pw.println("						} else {                                                                          ");
		pw.println("							error.insertAfter(element);                                                   ");
		pw.println("						}                                                                                 ");
		pw.println("					}                                                                                     ");
		pw.println("				});                                                                                       ");
        pw.println("                                                                                                          ");
		pw.println("			});                                                                                           ");
		pw.println("		</script>                                                                                         ");
		pw.println("	</head>                                                                                               ");
		pw.println("	<body>                                                                                                ");
		pw.println("		<form id='registerForm' action='registerCheck' method='get'>                                      ");
		pw.println("			<div class='col-md-2 text-right'>                                                             ");
		pw.println("				<h3>注册</h3>                                                                             ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'>                                                                  ");
		pw.println("				<label class='col-md-2 text-right'>用户名:</label>                                        ");
		pw.println("				<div class='col-md-6'>                                                                    ");
		pw.println("					<input type='text' name='username' placeholder='请输入用户名' />                      ");
		pw.println("				</div>                                                                                    ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'>                                                                  ");
		pw.println("				<label class='col-md-2 text-right'>密码:</label>                                          ");
		pw.println("				<div class='col-md-6'>                                                                    ");
		pw.println("					<input type='password' name='password' placeholder='请输入密码' id='password' />      ");
		pw.println("				</div>                                                                                    ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'>                                                                  ");
		pw.println("				<label class='col-md-2 text-right'>确认密码:</label>                                      ");
		pw.println("				<div class='col-md-6'>                                                                    ");
		pw.println("					<input type='password' name='comfirmpwd' placeholder='请输入确认密码' />              ");
		pw.println("				</div>                                                                                    ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'>                                                                  ");
		pw.println("				<label class='col-md-2 text-right'>Email:</label>                                         ");
		pw.println("				<div class='col-md-6'>                                                                    ");
		pw.println("					<input type='email' name='email' placeholder='Email' /></div>                         ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'>                                                                  ");
		pw.println("				<label class='col-md-2 text-right'>验证码:</label>                                        ");
		pw.println("				<div class='col-md-1 text-left'>                                                          ");
		pw.println("					<input type='text' name='checkCode' style='width:80px;' />                            ");
		pw.println("				</div>                                                                                    ");
		pw.println("				<div class='text-left'>                                                                   ");
		pw.println("					<img src='checkImage' id='checkImg' />                                                ");
		pw.println("					<script>                                                                              ");
		pw.println("						document.getElementById('checkImg').onclick = function() {                        ");
		pw.println("						var r = Math.random();                                                            ");
		pw.println("						this.src = 'checkImage?' + r;                                                     ");
		pw.println("						};                                                                                ");
		pw.println("					</script>                                                                             ");
		pw.println("				</div>                                                                                    ");
		pw.println("			</div>                                                                                        ");
		pw.println("			<div class='form-group row'><br />                                                            ");
		pw.println("				<div class='col-md-2'></div>                                                                      ");
		pw.println("				<div class='col-md-10'>                                                                           ");
		pw.println("					<input type='submit' value='注册' style='width:100px;height:35px;background-color:lightgoldenrdyellow;' />");
		pw.println("				</div>                                                                                           ");
		pw.println("			</div>                                                                                               ");
		pw.println("		</form>                                                                                                  ");
		pw.println("	</body>                                                                                                      ");
		pw.println("</html>                                                                                                          ");
	                                                                                                                               
		
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
