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
<title>幸福堂｜座っている人の降りる駅がわかる</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>座っている人の降りる駅がわかる<br><%=productList.get(4).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/退席判明.png" width="300" height="300" alt="shouhin5">
      <td>
      <td>「満員電車でいつも席に座れない！私の前に座っている人はいつ降りるんだろう...」<br>
<br>
こういう経験、ありませんか？<br>
<br>
周りの席はすぐに空くのに自分の前の人だけいつまでも降りずに結局目的地に...なんて日には<br>
今日はツイてないなぁと思っちゃいますよね。<br>
<br>
この商品は毎日のつらい通勤電車の手助けとなります。<br>
疲れた帰り道、苦しい椅子取りゲームとはもうおさらばです！<br></td>
    <tr>
  </table>

  <%
    if (!happyLife.getP_Buy_List().contains(productList.get(4))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(4).getP_name()%>を購入" name="購入" onclick="cartIn()">
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