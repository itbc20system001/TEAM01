<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javabeans.*"%>
<%
	Integer kp = (Integer) request.getAttribute("kp");
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
  <%if(happyLife.getMessage() == null){

	  }else {%>
	    <%= happyLife.getMessage() %>!<br>
    	<%= kp %>KP!<br>
    	現在の幸福ポイントは<%=happyLife.getHappypoint()%>KPです！<br>
    <% }%>



  </h2>
  <p>
    <a href=MyPage>マイページへ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>
