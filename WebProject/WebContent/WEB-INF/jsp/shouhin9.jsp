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
<title>幸福堂｜ラベルが一発で剥がれる</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>ラベルが一発で剥がれる<br><%=productList.get(8).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/ラベル.png" width="300" height="300" alt="shouhin5">
      <td>
      <td>「一発で綺麗にラベルを剥がしたい！」<br>
<br>
こういう経験、ありませんか？<br>
<br>
特に紙のラベルの場合なんて、<br>
細切れになったラベルが手に付着したりして<br>
イライラしちゃうかも…？<br>
<br>
そんなシチュエーションには、この商品。<br>
<br>
効果時間内ならば、どんなラベルが相手でも<br>
瞬時に、かつ綺麗に剥がすことが出来ます。<br>
<br>
お求めやすいお値段ですので、<br>
幸福堂の力のお試しにもオススメです。</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(8))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(8).getP_name()%>を購入" name="購入" onclick="cartIn()">
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