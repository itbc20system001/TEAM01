<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
    <%HappyLife happyLife =(HappyLife)session.getAttribute("happy"); %>
<%ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/kohukudo/kohukudo.css">
<h1 style="text-align:center"><a href="TOP"><img src="image/headerimage/幸福堂ロゴ_header.png" alt="kohukudo"></a></h1>
<nav class="nav">
<ul>
<li>ようこそ、<%=happyLife.getUsrName() %>さん</li>
<li>所有KP:<%=happyLife.getHappypoint() %>KP</li>
<li><a href="TOP"><img src="image/headerimage/幸福堂TOP.png" alt="TOP"></a></li>
<li><a href="Cart"><img src="image/headerimage/カート画面.png" alt="cart"></a></li>
<li><a href="Product"><img src="image/headerimage/商品一覧画面.png" alt="itiran"></a></li>
<li><a href="MyPage"><img src="image/headerimage/マイページ.png" alt="mypage"></a></li>
<li><a href="Logout"><img src="image/headerimage/ログアウト.png" alt="logout"></a></li>
<li><a href="Q&A"><img src="image/headerimage/Q_A.png" alt="Q&A"></a></li>
</ul>
</nav>
<nav class="nav2">
<ul>
</ul>
</nav>
</head>
<body>

</body>
</html>