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
<style type="text/css">
.botton{
  display : inline-block;
  border-radius :  45%;
  font-size : 19pt;
  text-align : center;
  cursor : pointer;
  padding : 16px 16px;
  background : #a64dff;
  color : #ffffff;
  line-height : 1em;
  opocity : 0.9;
  transition : .3s;
  box-shadow : 2px 2px 3px #666666;
}
.botton:hover{
  box-shadow : none;
  opocity : 1;
}
</style>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <form method="POST" action="Uranai">
    <input type="submit" name="submit" value="占う" class="botton">
  </form>
  <h1>※何回でも挑戦できます</h1>
  <h2>
  <%if(happyLife.getMessage() == null){

	  }else { if(kp != null){ %>

	    <%= happyLife.getMessage() %>!<br>
    	<%= kp %>KP<br>
    	現在の幸福ポイントは<%=happyLife.getHappypoint()%>KPです！<br>
    <% } }%>



  </h2>
  <p>
    <a href=MyPage>マイページへ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>
