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
<title>幸福堂｜商品一覧</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <%-- <header>
ようこそ、<%=happyLife.getUsrName() %>さん
所有KP:<%=happyLife.getHappypoint() %>KP
<a href="TOP">幸福堂TOP</a>
<a href="Cart">カート画面</a>
<a href="Product">商品一覧画面</a>
<a href="MyPage">マイページへ</a>
<a href="Logout">ログアウト</a>
</header> --%>
  <table align="center">
  <% for(int j = 0; j < productList.size(); j+=3){ %>

    <tr>
      <%
      	for (int i = j; i < productList.size(); i++) {
      %>
      <th><%=productList.get(i).getP_name()%><br><%=productList.get(i).getPrice()%>KP</th>

      <% if(i%3==2) break;
      	}
      %>
    </tr>

    <tr>
      <%
      	for (int i = j; i < productList.size(); i++) {
      %>
      <%-- <td><a href="/WEB-INF/jsp/shouhin<%=i+1 %>.jsp"><img src="image/<%=productList.get(i).getP_name() %>.png" width="200" height="200" alt="shouhin<%=i+1%>"></a></td>
 --%>
      <%-- <button type="image" src="image/<%=productList.get(i).getP_name() %>.png" width="200" height="200"  alt="shouhin<%=i+1%>" name="商品" value="<%=productList.get(i).getP_id()%>">
 --%>
      <td><form action="Shouhin" method="post">
          <button type="submit" name="商品" value="<%=productList.get(i).getP_id() - 1%>">
            <img src="image/<%=productList.get(i).getP_name()%>.png" width="200" height="200" alt="shouhin<%=i%>">
          </button>
        </form><br><br></td>

      <% if(i%3==2) break;
      	}
      %>

    </tr>

     <%
      }
    %>
  </table>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>