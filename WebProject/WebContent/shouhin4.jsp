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
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>信号に引っかからない<br><%=productList.get(3).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/信号.png" width="300" height="300" alt="shouhin1">
      <td>
      <td>
「あの信号にさえ捕まらなければ遅刻しなかったのに！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
家から駅までの全ての信号に引っかかった！なんて日には<br>
自分は信号に呪われているんじゃないかと錯覚しちゃいますね。<br>
<br>
この商品はむしろその逆、貴方に信号の祝福を与えます。<br>
信号に祝福された貴方はその一日、青信号にのみ出会います。<br>
万が一にも遅刻できない日にどうぞ。
</td>
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
  <jsp:include page="footer.jsp"/>
</body>
<script>
  var cartIn = function a() {
    alert('カートに追加しました');
  }
</script>
</html>