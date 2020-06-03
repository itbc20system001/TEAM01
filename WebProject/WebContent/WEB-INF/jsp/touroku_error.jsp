<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.HappyLife"%>
<%
	HappyLife happyLife = (HappyLife) request.getAttribute("KP");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜会員登録エラー</title>
<style type="text/css">
hr {
  border-color: darkred;
}
</style>
</head>
<body>
  <header>
    <link rel="stylesheet" href="kohukudo.css">
    <h1 style="text-align: center">
      <a href="TOP"><img src="image/headerimage/幸福堂ロゴ_login.png" alt="kohukudo"></a>
    </h1>
  </header>
  <h2>新規会員登録エラー</h2>
  <hr>
  <p>会員登録においてエラーがありました。申し訳ございませんが再度登録をお願いいたします。</p>
  <p>
    エラー内容:<%=happyLife.getMessage()%></p>
  <p>
    <a href="Register">新規会員登録画面へ</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>