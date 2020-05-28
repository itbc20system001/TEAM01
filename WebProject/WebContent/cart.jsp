<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
  <h1>カートの内容</h1>
  <%
  	for (int i = 0; i < happyLife.getP_Buy_List().size(); i++) {
  %>
  <p>
  <form action="CartServlet" method="POST">
    <%=happyLife.getP_Buy_List().get(i).getP_name()%>:
    <%=happyLife.getP_Buy_List().get(i).getPrice()%>KP <input type="submit" value="<%=happyLife.getP_Buy_List().get(i).getP_name() %>をカートから削除" name="削除" onclick="cartOut()">
  </form>
  </p>
  <%
  	}
  %>
  <p></p>

  <a href=BuyServlet>購入へ</a>
  <br>
  <a href=Product>商品一覧へ</a>
</body>
<script>
  var cartOut = function a() {
    alert('カートから削除しました');
  }
</script>
</html>