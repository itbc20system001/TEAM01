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
<title>幸福堂｜じゃんけん必勝</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>じゃんけん必勝<br><%=productList.get(12).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/ラベル.png" width="300" height="300" alt="shouhin5">
      <td>
      <td>「あそこでじゃんけんに勝ってればなあ。」<br>
<br>
こういう経験、ありませんか？<br>
<br>
給食の残ったプリンや、カードゲームの先攻後攻…。<br>
時として人生を左右するかもしれない勝負。<br>
<br>
それがじゃんけんです。<br>
<br>
「じゃんけん必勝」は必ずじゃんけんに勝てる<br>
シンプルかつパワフルな商品です。<br>
<br>
あのプロサッカー選手に完勝することも<br>
夢ではありません。</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(12))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(12).getP_name()%>を購入" name="購入" onclick="cartIn()">
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