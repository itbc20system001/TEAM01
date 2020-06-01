<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
	Payment payment = (Payment) session.getAttribute("payment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>
  <h1>幸福堂｜カートの内容</h1>
  <%
  	for (int i = 0; i < happyLife.getP_Buy_List().size(); i++) {
  %>
  <p>
  <form action="Cart" method="POST">
    <%=happyLife.getP_Buy_List().get(i).getP_name()%>:
    <%=happyLife.getP_Buy_List().get(i).getPrice()%>KP <input type="submit" value="<%=happyLife.getP_Buy_List().get(i).getP_name()%>をカートから削除" name="削除" onclick="cartOut()">
  </form>
  </p>
  <%
  	}
  %>
  <p></p>
  <%
  	if (happyLife.getP_Buy_List().size() != 0) {
  %>
  <a href=Buy>購入へ</a>
  <br>
  <%
  	} else {
  %>
  <p>カート内に商品がありません</p>
  <%
  	}
  %>
  <a href=Product>商品一覧へ</a>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
<script>
  var cartOut = function a() {
    alert('カートから削除しました');
  }
</script>
</html>