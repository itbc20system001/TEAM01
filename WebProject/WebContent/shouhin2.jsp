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
<title>幸福堂｜勝手に見つけやすいところに移動するリモコン</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
      <th>勝手に見つけやすいところに移動するリモコン</th>
    <tr>
    <td><img src="image/リモコン.png" width="300" height="300" alt="shouhin1">
    <td>
    <td>「外から帰ってきて汗だくなのにエアコンがなくてクーラーがつけられない！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
見たいテレビ番組が始まりそうなのに<br>
テレビのリモコンがない…なんて時もあるでしょう。<br>
<br>
この商品は、そんなリモコン問題を一括で解決してくれます。<br>
<br>
エアコン、テレビ、果ては車のキーまで。<br>
<br>
継続しての購入をお勧めしたい商品です。<br><!--  <%=productList.get(1).getPrice()%>KP -->
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(1))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(1).getP_name() %>を購入" name="購入" onclick="cartIn()">
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