<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "javabeans.HappyLife"%>
    <%HappyLife happyLife = (HappyLife)request.getAttribute("KP"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<p>幸福ポイントが<%=happyLife.getHappypoint() %>KP付与されました。</p>
<p><a href="top.jsp">TOP画面へ</a></p>
</body>
</html>