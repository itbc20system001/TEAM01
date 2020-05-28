<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%HappyLife happyLife =(HappyLife)session.getAttribute("happy"); %>
<%ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信号に引っかからない</title>
</head>
<body>
  <table>
    <th>信号に引っかからない<br><%=productList.get(3).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/kari.gif" width="300" height="300" alt="shouhin1">
      <td>
      <td>「あの信号にさえ捕まらなければ遅刻しなかったのに！」<br>
こういう経験、ありませんか？</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(3))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(3).getP_name() %>を購入" name="購入" onclick="cartIn()">
  </form>
  <%
  	} else {
  %>
  カートに入っています
  <%
  	}
  %>
</body>
<script>
  var cartIn = function a() {
    alert('カートに追加しました');
  }
</script>
</html>