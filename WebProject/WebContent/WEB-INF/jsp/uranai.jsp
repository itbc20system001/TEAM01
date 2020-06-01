<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <form method="POST" action="Uranai">
    <input type="submit" name="submit" value="占う">
  </form>
  <h1>※何回でも挑戦できます</h1>
  <h2>
    あなたは<%=happyLife.getMessage()%>です
  </h2>
  <h3><%=happyLife.getHappypoint()%>KP獲得しました！
  </h3>
  <p>
    <a href=MyPage>マイページへ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>
