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
<style type="text/css">
table{
text-align:center;
}
th{
padding:12px;
border-bottom:1px dashed darkred;
text-align:center;
}
td{

padding:12px;
border-bottom:1px dashed darkred;
text-align:center;
}
</style>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>
  <h1>ショッピングカート</h1>

  <%
  	if (happyLife.getP_Buy_List().size() != 0) {
  %>

  <table>
  <thead>
  <tr>
  <th>商品名</th>
  <th>小計</th>
  <th>削除</th>
  </tr>
  </thead>

  <%
    for (int i = 0; i < happyLife.getP_Buy_List().size(); i++) {
  %>
  <tr>
  <form action="Cart" method="POST">
    <td ><%=happyLife.getP_Buy_List().get(i).getP_name()%>
    <br><img src="image/<%=happyLife.getP_Buy_List().get(i).getP_name()%>.png" width="80" height="80" alt="shouhin<%=i%>"></td>
    <td><%=happyLife.getP_Buy_List().get(i).getPrice()%>KP</td>
    <td> <input type="submit" value="<%=happyLife.getP_Buy_List().get(i).getP_name()%>をカートから削除" name="削除" onclick="cartOut()"></td>
  </form>
  </tr>
  <%
    }
  %>

  </table>
  <br><br><a href=Buy>購入へ</a>
  <%
  	} else {
  %>
  <p>カート内に商品がありません</p>
  <%
  	}
  %>
  <br><a href=Product>商品一覧へ</a>
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