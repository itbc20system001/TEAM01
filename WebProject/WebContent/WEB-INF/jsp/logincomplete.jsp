<%@page import="model.HappyGive"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.*"%>
<%@ page import="model.BalanceRegisterLogic" %>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
    Login login = (Login)request.getAttribute("login");

    HappyGive happyGive = new HappyGive();
    int sum=happyGive.pointExcute();
    BalanceRegisterLogic brl = new BalanceRegisterLogic();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜登録完了</title>
</head>
<body>
  <header>
    <link rel="stylesheet" href="kohukudo.css">
    <h1 style="text-align: center">
      <a href="TOP"><img src="image/kohukudo_logo_touka.png" alt="kohukudo"></a>
    </h1>
  </header>
  <p>
    ログインボーナス！</p>
    <p>
    <%=sum%>KP加算！！！</p>
    <%happyLife.setHappypoint(happyLife.getHappypoint()+sum);
      brl.execute(happyLife);
    %>
<p>現在のKPは、<%=happyLife.getHappypoint()%>KPです。
  </p>
  <p>
    <a href="Product">商品一覧へ</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>