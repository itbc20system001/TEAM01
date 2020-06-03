<%@page import="model.HappyGive"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.*"%>
<%@ page import="model.BalanceRegisterLogic" %>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
    Login login = (Login)session.getAttribute("log_buy_count");
    ArrayList<HappyLife> happyUser = (ArrayList) session.getAttribute("happyuser");
    HappyGive happyGive = new HappyGive();
    int sum=happyGive.pointExcute();
    BalanceRegisterLogic brl = new BalanceRegisterLogic();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>しあわせ</title>
<style>
html, body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}
html {
  display: table;
}
body {
  background-color: black;
  color:pink;
  display: table-cell;
  text-align: center;
  vertical-align: middle;
}

.center {
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}
</style>
</head>
<body>
<p>すべてのこうふくぽいんとをつかいきったあなたはとくべつにしあわせなところへいけます</p>
<p>いまそこでは<%=happyUser.size() %>にんがしあわせです</p>
<%-- <%for(int i=0;i<happyUser.size();i++){ %>
<p><%=happyUser.get(i).getUsrName() %>さん</p>
<%} %> --%>
<p>あなたもようこそ</p>
<form action="-" method="POST">
<input type="submit" value="はい" name="go">
<input type="submit" value="いいえ" name="go">
</form>
</body>
</html>