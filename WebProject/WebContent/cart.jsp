<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="javabeans.*" %>
    <%@page import ="java.util.ArrayList" %>
    <%HappyLife happyLife =(HappyLife)session.getAttribute("happy"); %>
    <%ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
<h1>カートの内容</h1>

<p>商品1 : 商品A説明～～　○○KP　<a href=CartServlet method="post">削除</a></p>
<p>商品2 : 商品B説明～～　○○KP　<a href=CartServlet method="post">削除</a></p>

<a href=BuyServlet>購入へ</a><br>
<a href=kakushouhin.jsp>商品一覧へ</a>
</body>
</html>