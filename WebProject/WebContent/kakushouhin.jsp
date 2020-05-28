<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%HappyLife happyLife =(HappyLife)session.getAttribute("happy"); %>
<%ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
<table align="center">
<tr>
<%for(int i=0;i<productList.size();i++){ %>
<th><%=productList.get(i).getP_name() %><br><%=productList.get(i).getPrice() %>KP</th>
<%} %>
</tr>

<tr>
<td><a href="shouhin1.jsp"><img src="image/kari.gif" width="200" height="200" alt="shouhin1"></a></td>
<td><a href="shouhin2.jsp"><img src="image/kari.gif" width="200" height="200" alt="shouhin2"></a></td>
<td><a href="shouhin3.jsp"><img src="image/kari.gif" width="200" height="200" alt="shouhin3"></a></td>
<td><a href="shouhin4.jsp"><img src="image/kari.gif" width="200" height="200" alt="shouhin4"></a></td>
</tr>

</table>

<a href="CartServlet">カートへ</a>
</body>
</html>