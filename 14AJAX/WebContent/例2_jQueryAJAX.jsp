<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.3.1.min.js" ></script>
<script>
	$(function(){
		
		
		$("#btn1").click(function(){
			$("#div01").load("test1.txt");
		});
		
		$("#btn2").click(function(){
			$("#div02").load("test2.txt #p2");
		});
		
		$("#submitBtn").click(function(){
			
			console.log("xxx");
			

			/*
			//格式: $.get(url地址,参数,回调函数,返回数据类型)
			$.get("login", 
					{ username: $("#username").val(), password: $("#password").val(),age:$("#age").val() },
					  function(data){
						console.log(data);
						//$("#result").text(data);
						var jsonObj = JSON.parse(data);
						$("#result").text(jsonObj.username+","+jsonObj.result);
					}
				);
			*/
			
			$.get("login", 
					{ username: $("#username").val(), password: $("#password").val(),age:$("#age").val() },
					  function(data){
						$("#result").text(data.username+","+data.result);
					  },
					"json"
				);


			
			// jQuery 3.3.1 版本适用
			/*
			$.get({
				url:"login",
				data:{
					"username":$("#username").val(),
					"password":$("#password").val(),
					"age":$("#age").val()
				},
				success:function(result){
					console.log(result);
				}
			});
			*/

			
			/*
			// jQuery 3.3.1 版本适用
			$.post({
				url:"login",
				data:{
					"username":$("#username").val(),
					"password":$("#password").val(),
					"age":$("#age").val(),
				},
				sucess:function(result){
					console.log(result);
				},//请求失败的回调函数
				error:function(msg){
				    alert( "Error");
				}
			});
			*/
		});
	});
</script>
</head>
<body>
<div id="div01"></div>
<button id="btn1">获取外部数据</button>
<div id="div02"></div>
<button id="btn2">获取外部数据</button>

<form id="form1">
	<table border="1">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username" id="username" value="admin"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name="password" id="password" value="123"/></td>
		</tr>
		<tr>
			<td>年龄:</td>
			<td><input type="text" name="age" id="age" value="18"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="button" value="注册" id="submitBtn"></td>
		</tr>
	</table>
</form>

<div id="result"></div>
</body>
</html>