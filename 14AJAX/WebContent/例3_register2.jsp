<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>

<script>

	/*
	function checkName()
	{
		$.get("check",
			  {username:$("#username").val()},
			  function(data){
				var info = document.getElementById("info");
				info.innerHTML= data;
			  });
	}
	*/
	
	$(function(){
		
		$("#username").keyup(function(){
			console.log("keyup");
			
			$.get("check",
				{username:$("#username").val()},
				  function(data){
						console.log(data);
						var info = document.getElementById("info");
						info.innerHTML= data;
					  });
		});
	});

</script>
</head>
<body>
<form action="registerchk">
用户名:<input type="text" name="username" id="username"><button type="button" onclick="checkName();">检测</button><span id="info"></span><br />
密码:<input type="password" name="password"><br />
<input type="submit" value="注册">

</form>
</body>
</html>