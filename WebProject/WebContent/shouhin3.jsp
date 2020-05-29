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
<title>並び始めたらすでに一番前にいる</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>並び始めたらすでに一番前にいる<br><%=productList.get(2).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/行列.png" width="300" height="300" alt="shouhin1">
      <td>
      <td>
「超人気グッズを絶対に買いたい！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
この商品をお買い上げいただければ、<br>
貴方が行列の先頭にお並び出来ることを約束致します。<br>
<br>
詳しい手法は企業秘密とさせていただきますが、<br>
効果が絶大な分、高額になります。<br>
ご了承くださいませ。<br>
</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(2))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(2).getP_name() %>を購入" name="購入" onclick="cartIn()">
  </form>
  <%
  	} else {
  %>
  カートに入っています
  <%
  	}
  %>
    <jsp:include page="footer.jsp"/>
</body>
<script>
  var cartIn = function a() {
    alert('カートに追加しました');
  }
</script>
</html>