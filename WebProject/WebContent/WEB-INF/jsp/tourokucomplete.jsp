<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.HappyLife"%>
<%
	HappyLife happyLife = (HappyLife) request.getAttribute("KP");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜登録完了</title>
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
    <h2>新規会員登録完了</h2>
  <hr>
  <h3>
    お疲れさまでした。
     <br>これにて新規会員登録完了です。

    <p>幸福ポイントが、「<%=happyLife.getHappypoint()%>KP」付与されました。</p>
    <br>付与された幸福ポイントを用いて、幸福堂でのお買い物をお楽しみください。
    <p>つづいて、下記「TOP画面へ」をクリックして、TOP画面からログインをお願いいたします。</p>
  </h3>
  <p>
    <a href="TOP">TOP画面へ</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>