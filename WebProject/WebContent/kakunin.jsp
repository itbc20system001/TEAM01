<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
    Payment payment = (Payment) session.getAttribute("payment");
%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文内容確認</title>
</head>
<body>


  <%
  	for (int i = 0; i < happyLife.getP_Buy_List().size(); i++) {
  %>
  <p>
    <%=happyLife.getP_Buy_List().get(i).getP_name()%>:
    <%=happyLife.getP_Buy_List().get(i).getPrice()%>KP
  </p>
  <%
  	}
  %>
  <p>
  購入前:<%= happyLife.getHappypoint() %>KP<br>
  購入後:<%= payment.getChange() %>KP
  </p>

  <a href=BoughtServlet>購入確定</a>
  <br>
  <a href=CartServlet>戻る</a>
</body>
</html>