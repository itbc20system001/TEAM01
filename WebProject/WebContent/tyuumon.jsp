<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabeans.Payment" %>
<%
Payment point = (Payment)request.getAttribute("point");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>
</head>
<body>

<h2>注文が完了しました</h2>
<p><%= point.getPoint() %>ポイント獲得！</p>
<h3>あなたに幸福が訪れますように...</h3>

<a href="kakushouhin.jsp">商品一覧へ</a>

</body>
</html>