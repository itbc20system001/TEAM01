<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javabeans.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.LinkedHashSet"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%
	ArrayList<HappyLife> ordered = (ArrayList) request.getAttribute("order");
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜購入履歴</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <h1>過去の注文</h1>
  <table>
    <%
    	for (int i = 0; i < happyLife.getOrdered_List().size(); i++) {
    %>
    <tr>
      <td><%=productList.get(i).getP_name()%></td>
      <%
      	for (int j = 0; j < ordered.size(); j++) {
      			if (ordered.get(j).getPo_id() == happyLife.getPo_id_List().get(i)) {
      %>
      <td><%=ordered.get(j).getLimitDate().format(f)%>まで</td>
      <%
      	if (now.isAfter(ordered.get(j).getLimitDate())) {
      %>
      <td>有効期限切れ</td>
      <%
      	}
      %>
      <%
      	}
      %>
      <%
      	}
      %>
    </tr>
    <%
    	}
    %>
  </table>

  <p>
    <a href=MyPage>マイページへ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>