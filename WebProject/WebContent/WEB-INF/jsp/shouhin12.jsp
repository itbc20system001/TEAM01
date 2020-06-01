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
      <td><img src="image/花粉症.png" width="300" height="300" alt="shouhin7">
      <td>
      <td>「つらい鼻水、鼻づまり、くしゃみ、目のかゆみ...」<br>
<br>
こういう経験、ありませんか？<br>
<br>
春は私たちを苦しめるスギ花粉が到来します<br>
この時期になると全国の杉の木を切り倒したい気持ちが芽生えますよね<br>
<br>
この商品は、そんな花粉症に悩むあなたにオススメです<br>
詳しい手法は企業秘密とさせていただきますが、<br>
薬では比べ物にならないほどの絶大な効果を発揮します。<br>
継続しての購入をお勧めしたい商品です。<br></td>
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