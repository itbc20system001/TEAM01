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
<title>幸福堂｜自販のルーレット</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>自販のルーレットであたりが出る<br> <%=productList.get(11).getPrice()%> KP
    </th>
    <tr>
      <td><img src="image/自販.png" width="300" height="300" alt="shouhin1">
      <td>
      <td>
「当たり付き自販機のルーレットが、当たらない！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
今までの人生で一回も当たったことのないかたも多いはず…。<br>
<br>
そんな悩みを解決してくれるのが、この商品です。<br>
<br>
内容はいたってシンプル！<br>
有効期限内に限って１回だけルーレットが当たります。<br>
普段は控えていた気になる商品もこの機会に飲めちゃいます。<br>
<br>
この商品で、ちいなさ幸せを感じてみませんか？<br>
</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(11))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(11).getP_name() %>を購入" name="購入" onclick="cartIn()">
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