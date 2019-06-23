<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传页</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#myfile").change(function(){
			var src=$(this).val();
			$("#img").attr("src",src);
		});
	});
</script>
</head>
<body>
<form action="upload.action" enctype="multipart/form-data" method="post">
	<input type="file" id="myfile" name="myfile"/><br>
	<button>上传</button>
</form>
<img alt="图片走丢了" src="images/${picName}">
<img id="img" alt="图片"  src=""/>
</body>
</html>