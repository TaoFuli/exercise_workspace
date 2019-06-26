<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		
		// 请求省的信息
		$.ajax({
			url:"region",
			success:function(result){
				console.log(result);				
				// 找到省Select
				var provinceSel = $("#province");
				// 遍历region结果
				for(var i in result)
				{
					var region = result[i];
					// 添加子Option
					provinceSel.append('<option value="'+region.id+'">'+region.name+'</option>');
				}
			},
			dataType:"JSON"
		});
		
		
		$("#province").change(function(){
				console.log("选择了"+this.value);
				$("#city").html("<option value=\"none\">--请选择市--</option>");
				if(this.value == "none")
				{
					$("#area").html("<option value=\"none\">--请选择区域--</option>");
					return;
				}
				
				$.ajax({
					url:"region",
					data:{"parentid":this.value},
					success:function(result){
						console.log(result);				
						// 找到省Select
						var provinceSel = $("#city");
						// 遍历region结果
						for(var i in result)
						{
							var region = result[i];
							// 添加子Option
							provinceSel.append('<option value="'+region.id+'">'+region.name+'</option>');
						}
					},
					dataType:"JSON"
				});
		});
		
		
		
		$("#city").change(function(){
			console.log("选择了"+this.value);
			$("#area").html("<option value=\"none\">--请选择区域--</option>");
			if(this.value == "none")
			{
				return;
			}
			
			$.ajax({
				url:"region",
				data:{"parentid":this.value},
				success:function(result){
					console.log(result);				
					// 找到省Select
					var provinceSel = $("#area");
					// 遍历region结果
					for(var i in result)
					{
						var region = result[i];
						// 添加子Option
						provinceSel.append('<option value="'+region.id+'">'+region.name+'</option>');
					}
				},
				dataType:"JSON"
			});
	});
	});
</script>
</head>
<body>
	<center>
		<select id="province">
		  <option value="none">--请选择省--</option>
		</select>
		<select id="city">
			<option value="none">--请选择市--</option>
		</select>
		<select id="area">
			<option value="none">--请选择县或区--</option>
		</select>
	</center>

</body>
</html>