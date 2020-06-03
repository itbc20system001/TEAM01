<%@page import="model.HappyGive"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.*"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
	Login login = (Login) session.getAttribute("log_buy_count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜マイページ</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <h2>
    あなたは
    <%
  	if (login.getLogin_count() >= 30 && login.getBuy_count() >= 120) {
  %>
    ハッピー会員です。購入商品の有効期限が2倍！
    <%
  	} else {
  %>
    通常会員です。
    <%
  	}
  %>
  </h2>
  <ul>
    <li><a href=PurchaseHistory>購入履歴</a></li>
    <li><a href=UserInfo>会員情報</a></li>
    <li><a href=Uranai>占い</a></li>
  </ul>

  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>