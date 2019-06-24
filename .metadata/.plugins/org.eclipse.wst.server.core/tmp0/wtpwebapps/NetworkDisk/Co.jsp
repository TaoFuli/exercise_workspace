<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<title>Zero Clipboard Test</title>
<meta charset="utf-8">
<script type="text/javascript" src="js/ZeroClipboard.js"></script>
<script type="text/javascript" src="js/ZeroClipboard.swf"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<button id="copy-button" data-clipboard-text="Copy Me!" title="共享链接" >复制到剪贴板</button>
	<script type="text/javascript">
		var client = new ZeroClipboard(document.getElementById("copy-button"));
		client.on("ready", function(readyEvent) {
			client.on("aftercopy", function(event) {
				alert("Copy Success. " + event.data["text/plain"]);
			});
		});
	</script>
</body>
</html>