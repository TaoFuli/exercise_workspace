<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市区三级联动</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {  //全部代码加载完毕进行初始化
		
		// 初始化省市区
		initAddress();
 
		// 更改省份后的操作//选择select标签中name='rovince'的标签
		$("select[name='province']").change(function() {
 
				var provCode = $("select[name='province']").val();
 
				getCity(provCode);
 
			});
 
		// 更改城市后的操作//选择select标签中name='city'的标签
		$("select[name='city']").change(function() {
			var cityCode = $("select[name='city']").val();
			getArea(cityCode);
		});
 
	});
 
	function initAddress() {
 
		var firstProvCode;
		// ajax请求所有省份
		$.get("address", {
			method : "initProvince"
				}, function(data) {
						$.each(data, function(i, d) {
							$("select[name='province']").append(
								"<option value='"+d.code+"'>" + d.name	
								+ "</option>");
				/* 这里的d.code和d.name是要必需对应province类code和name字段 */
								});
 
				// 获取第一个省份的code
					firstProvCode = data[0].code;
					/* 这里的.code也是要必需对应province类code字段 。
					//一个province类的json对象中包含有province：{'id':10000,'code':'410000','name':'河南省'}*/
					//一个City类的json数组对象则包含有多个json对象,
					//data[]  :[{'id':100,'code':'410100','name':'郑州市','province':'410000'},{'id':101,'code':'410800','name':'开封市','province':'410000'},
					//				{'id':102,'code':'410300','name':'洛阳市','province':'410000'}]
					// 根据第一个省份code获取对应城市列表
					getCity(firstProvCode);
			}, 'json');
		}
 
	//获取对应城市列表（里面包括获取第一个城市的区县列表）
	function getCity(provCode) {
 
			var firstCityCode;
 
			// ajax请求所有市级单位
			$.get("address", {
						method : "getCity",
						provCode : provCode
					}, function(data) {
 
					// 先清空城市下拉框
						$("select[name='city']").empty();
 
							$.each(data, function(i, d) {
							$("select[name='city']").append(
										"<option value='"+d.code+"'>" + d.name
										+ "</option>");
							/* 这里的d.code和d.name是要必需对应City类code和name字段 */
									});
			
						// 获取第一个城市的code
						firstCityCode = data[0].code;
						// 根据第一个城市code获取对应区县列表/* 这里的.code也是要必需对应City类code字段 。*/
						getArea(firstCityCode);
					}, 'json');
		}
 
	function getArea(cityCode) {
 
			// ajax请求所有区县单位
			$.get("address", {
						method : "getArea",
						cityCode : cityCode
					}, function(data) {
			
						// 先清空区县下拉框
							$("select[name='area']").empty();
							$.each(data, function(i, d) {
											$("select[name='area']").append(
												"<option value='"+d.code+"'>" + d.name
												+ "</option>");
											/* 这里的d.code和d.name是要必需对应Area类code和name字段 */
										});
					}, 'json');
		}
</script>
</head>
<body>
	<h2>省市区三级菜单联动</h2>
	请选择：
	<select name='province'></select>
	<select name='city'></select>
	<select name='area'></select>
</body>
</html>