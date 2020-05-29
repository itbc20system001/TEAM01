<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javabeans.*"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜占い</title>
</head>
<body>
	<form method="POST" action="UranaiServlet">
		<input type="submit" name="submit" value="占う">
	</form>
	<h1>※何回でも挑戦できます</h1>
	<h2>
		あなたは<%=happyLife.getMessage()%>です
	</h2>
	<h3><%=happyLife.getHappypoint()%>KP獲得しました！
	</h3>
	<p>
		<a href=mypage.jsp>マイページへ戻る</a>
	</p>
</body>
</html>
