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
<title>幸福堂｜静電気</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>静電気がなくなる<br> <%=productList.get(10).getPrice()%> KP
    </th>
    <tr>
      <td><img src="image/静電気.png" width="300" height="300" alt="shouhin1">
      <td>
      <td>
冬場になるとおこる「バチッ！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
静電気の対策はみなさんお持ちでしょう。<br>
しかし、それうまく効いてますか？<br>
もしくはそれ、面倒ではありませんか？<br>
<br>
個人レベルでの対策はやまほどあれど、どれが効くかわかりませんよね。<br>
<br>
そんなときにこの商品<br>
冬場のストレスとはまったくの無縁です！<br>
ノンストレスな一日をどうぞ。<br>
</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(10))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(10).getP_name() %>を購入" name="購入" onclick="cartIn()">
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