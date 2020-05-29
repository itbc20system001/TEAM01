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
<title>最初からシャワーから温水が出る</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>最初からシャワーから温水が出る<br><%=productList.get(0).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/シャワー.png" width="300" height="300" alt="shouhin1">
      <td>
      <td>「温かいシャワーをすぐ浴びたいのにお湯になるのが遅い…。」<br>
<br>
こういう経験、ありませんか？<br>
<br>
酷いときは1分以上も冷水のままの人もいるとか…。<br>
<br>
そんな悩みを解決してくれるのが、この商品です。<br>
<br>
内容はいたってシンプル！<br>
お風呂や台所や洗面所の蛇口からいきなりお湯が出てきます。<br>
<br>
特に冬場は多くのお客様にご愛顧していただいております。</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(0))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(0).getP_name()%>を購入" name="購入" onclick="cartIn()">
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