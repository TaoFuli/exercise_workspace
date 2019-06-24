<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css"
		href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="container">
	<ul class="easyui-tree">
        <li>
            <span>我的资料</span>
            <ul>
                <li>
                    <span>下载目录</span>
                    <ul>
                        <li><span>电影</span></li>
                        <li><span>音乐</span></li>
                        <li><span>图片</span></li>
                    </ul>
                </li>
                <li><span>应用管家</span></li>
                <li><span>商用办公</span></li>
            </ul>
        </li>
        <li><span>上传目录</span></li>
        <li>
	        <div style="width:200px;height:auto;border:1px solid #ccc;">
				<ul id="tt" class="easyui-tree">
					<li>url="tree_data.json"</li>
				</ul>
			</div>
		</li>
    </ul>
 </div>
</body>
</html>