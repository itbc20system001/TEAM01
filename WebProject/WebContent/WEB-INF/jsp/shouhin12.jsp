<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>幸福堂｜花粉症の症状がなくなる</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>花粉症の症状がなくなる<br><%=productList.get(11).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/kafun_megane.png" width="300" height="300" alt="shouhin7">
      <td>
      <td>「「もう寝なければいけないのに全然寝付けない...」<br>
<br>
こういう経験、ありませんか？<br>
<br>
次の日に朝早く家を出なければいけないのに気づけばもう1時...<br>
寝ようと焦れば焦るほど目が冴えてきてしまいますよね<br>
<br>
この商品は、そんな不眠症に悩むあなたにオススメです<br>
詳しい手法は企業秘密とさせていただきますが、<br>
効果が絶大な分、高額になります。<br>
ご了承くださいませ。<br></td>
    <tr>
  </table>

  <%
    if (!happyLife.getP_Buy_List().contains(productList.get(11))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(11).getP_name()%>を購入" name="購入" onclick="cartIn()">
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
</body>
</html>