<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javabeans.HappyLife"%>
<%
	HappyLife happyLife = (HappyLife) request.getAttribute("KP");
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
    幸福ポイントが<%=happyLife.getHappypoint()%>KP付与されました。
  </p>
  <p>
    <a href="TOP">TOP画面へ</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>