<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javabeans.HappyLife"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品1</title>
</head>
<body>
  <table>
    <th>商品1<br>100KP
    </th>
    <tr>
      <td><img src="image/kari.gif" width="300" height="300" alt="shouhin1">
      <td>
      <td>商品1です。あなたに幸福とかあるでしょう。</td>
    <tr>
  </table>

  <%
  	if (happyLife.getProductid() == 0) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="商品1を購入" name="購入" onclick="cartIn()">
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