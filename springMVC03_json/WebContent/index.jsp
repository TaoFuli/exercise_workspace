<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			var params= '{"id":1001,"name":"zhangsan","price":15.5,"detail":"hehe"}';
			$.ajax({
				url : "${pageContext.request.contextPath}/set1.action",
				data : params,
				contentType : "application/json;charset=UTF-8",
				type:"post",
				success:function(rs){
					alert(rs);
				}
			});
		});
	});
</script>
</head>
<body>
<button id="btn">传递JSON</button>
</body>
</html>