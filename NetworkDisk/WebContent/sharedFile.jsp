<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
			function loaddata(){
				//jquery post方法，使用postI(url,提交的数据,回调函数)
				
				$.ajax({
						type:"get",
						url:"share1.do",
						data:{"sid":12},
						dataType:"json",
						asycn:true,
						success:function(data){
							alert("123456");
							//var jsonstr=eval(data);
						for(var i=0;i<data.length;i++)
						{
							$("#s1").append(data[i].filename);
						}
					},
					error:function(err){
						alert("发生了错误！"+err);
					}
				});
			}
</script>
</head>
<body>
<button id="btn" onclick="loaddata()">按钮</button>
<div id="s1"></div>
</body>
</html>