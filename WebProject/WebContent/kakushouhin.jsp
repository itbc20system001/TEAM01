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
<title>幸福堂｜商品一覧</title>
</head>
<body>
<header>
ようこそ、<%=happyLife.getUsrName() %>さん
所有KP:<%=happyLife.getHappypoint() %>KP
<a href="top.jsp">幸福堂TOP</a>
<a href="CartServlet">カート画面</a>
<a href="Product">商品一覧画面</a>
<a href="mypage.jsp">マイページへ</a>
<a href="logout_kakunin.jsp">ログアウト</a>
</header>
<table align="center">
<tr>
<%for(int i=0;i<productList.size();i++){ %>
<th><%=productList.get(i).getP_name() %><br><%=productList.get(i).getPrice() %>KP</th>
<%} %>
</tr>

<tr>
<td><a href="shouhin1.jsp"><img src="image/シャワー.png" width="200" height="200" alt="shouhin1"></a></td>
<td><a href="shouhin2.jsp"><img src="image/リモコン.png" width="200" height="200" alt="shouhin2"></a></td>
<td><a href="shouhin3.jsp"><img src="image/行列.png" width="200" height="200" alt="shouhin3"></a></td>
<td><a href="shouhin4.jsp"><img src="image/信号.png" width="200" height="200" alt="shouhin4"></a></td>
</tr>
</table>
<a href="CartServlet">カートへ</a>
</body>
</html>