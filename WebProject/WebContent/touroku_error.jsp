<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "javabeans.HappyLife"%>
        <%HappyLife happyLife = (HappyLife)request.getAttribute("KP"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜会員登録エラー</title>
</head>
<body>
<p>会員登録においてエラーがありました。申し訳ございませんが再度登録をお願いいたします。</p>
<p>エラー内容:<%=happyLife.getMessage() %></p>
<p><a href="touroku.jsp">新規会員登録画面へ</a></p>

</body>
</html>