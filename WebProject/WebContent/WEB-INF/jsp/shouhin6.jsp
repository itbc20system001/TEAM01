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
<title>幸福堂｜目当てのページが一発で開ける</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>目当てのページが一発で開ける<br><%=productList.get(5).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/ページジャンプ.png" width="300" height="300" alt="shouhin6">
      <td>
      <td>「あれ？この単語テキストの何ページに書いてあったっけ？」<br>
<br>
こういう経験、ありませんか？<br>
<br>
テキストを開くとき、少し通り過ぎてしまってわざわざページをめくっていく<br>
ほんの少しの時間ですけどもったいないですよね<br>
<br>
この商品は、効率よく勉強を行いたいあなたにオススメします<br>
試験前や勉強で追い込みをかけたいときにぜひ...<br></td>
    <tr>
  </table>

  <%
    if (!happyLife.getP_Buy_List().contains(productList.get(5))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(5).getP_name()%>を購入" name="購入" onclick="cartIn()">
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