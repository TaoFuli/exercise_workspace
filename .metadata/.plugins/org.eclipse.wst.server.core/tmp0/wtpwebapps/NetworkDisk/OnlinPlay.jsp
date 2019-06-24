<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
<!-- 添加播放器的样式文件 -->
<link href="css/video-js.min.css" rel="stylesheet" type="text/css">
<!-- 添加支持在线播放的脚本文件 -->
<script src="js/video.min.js"></script>
<!-- 当不支持H5的同时，则调用flash插件播放 -->
<script>videojs.options.flash.swf="video-js.swf";</script>

<script type="text/javascript">
			var myPlayer=videojs("#example_video_1");
			videojs("#example_video_1").ready(function(){
				var myPlayer=this;
				myPlayer.play();
			});
			var howMuchIsDownloaded=myPlayer.bufferedPercent();
			myPlayer.on("howMuchIsDownloaded",function(){
					console.log("howMuchIsDownloaded")
				});
			myPlayer.on("pause",function(){
				myPlayer.log("pause");
			});
		</script>
</head>
<body>
	<div class="d-video">
		<video id="example_video_1" class="video-js vjs-default-skin vjs-big-play-centered" 
		controls 
			preload="none" width="1140px" height="550px"
			poster="http://video-js.zencoder.com/oceans-clip.png" 
			data-setup='{"example_option":true}'>
			<source src="download/mp4/201810311954.mp4" type='video/mp4' />
			<source src="" type='video/webm' />
			<source src="" type='video/ogg' />
		</video>
		
	</div>
</body>
</html>