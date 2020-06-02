<%@page import="model.TextSupportLogic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
	TextSupportLogic txt = new TextSupportLogic();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜商品詳細</title>
<style type="text/css">
td {
	padding: 8px;
}

td.text:first-letter {
	font-size: 3em;
	font-weight: bold;
	color: black;
}
</style>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <table>
    <th><%=txt.PrintTitle(happyLife.getProductid())%><br><%=productList.get(happyLife.getProductid()).getPrice()%>KP</th>
    <tr>
      <td><img src="image/<%=productList.get(happyLife.getProductid()).getP_name()%>.png" width="300" height="300" alt="shouhin1">
      <td class="text"><%=txt.PrintMain(happyLife.getProductid())%></td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(happyLife.getProductid()))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(happyLife.getProductid()).getP_name()%>を購入" name="購入" onclick="cartIn()">
  </form>
  <%
  	} else {
  %>
  カートに入っています
  <%
  	}
  %>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
<script>
  var cartIn = function a() {
    alert('カートに追加しました');
  }
</script>
</html>