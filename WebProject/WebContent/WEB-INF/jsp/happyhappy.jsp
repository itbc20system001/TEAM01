<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>しあわせしあわせしあわせしあわせしあわせしあわせしあわせしあわせしあわせ</title>
<style>
body{
background-image: url(image/ブラクラ.gif);
background-size:25% auto;
}
</style>

</head>
<body>

<iframe src="non.mp3"  allow="autoplay" id="audio" style="display:none"></iframe>
<audio autoplay="autoplay" loop="loop" src="sound/ブラクラ.wav" controls="controls" preload="auto" style="display:none">
</audio>
<%for(int i=0;i<1000000;i++){ %>
<br>
<%} %>
</body>
</html>