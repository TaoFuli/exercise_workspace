<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
<script>


	function sel(div)
	{
		console.log(div);
		console.log($(div).text());
		$("#city").val( $(div).text());
	}
	
	$(function(){
		
		$("#city").keyup(function(){
			
			$("#searchHelpDiv").html("");
			$("#searchHelpDiv").css("display","none");
			
			if($("#city").val()!="")
			{
				$.ajax({
				url:"searchHelp",
				data:{"city":$("#city").val()},
				success:function(data){
					
					if(data.length>0)
					{
						for(var i in data)
						{
							 $("#searchHelpDiv").append(
									 "<div onclick='sel(this)'>"+data[i].name+"</div>");
						}
						$("#searchHelpDiv").css("display","block");	
					}
					
				},
				dataType:"json"
				});
			}
		});
	});
	
	function search()
	{
		$.ajax({
			url:"search",
			data:{"city":$("#city").val()},
			success:function(data){
				$("#result").text(data);
			}
		});
	}
	
	
</script>
	<style>
		#searchHelpDiv{
			width: 150px;
			height: 100px;
			background-color: lightblue;
			position: absolute;
			left:78px;
			top:33px;
		}
	</style>
</head>
<body>
	
	搜索城市:<input type="text" name="city" value="无锡" id="city"/><input type="button" value="搜索" onclick="search()"><br />
	结果:<span id="result">江苏省 > 无锡市</span>
	
	<div id="searchHelpDiv"></div>

</body>
</html>