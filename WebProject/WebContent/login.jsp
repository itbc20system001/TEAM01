<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜ログイン</title>
</head>
<body>
<form action="LoginServlet" method="post">
メールアドレス:<input type="text" name="email"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<p><a href="touroku.jsp">ご新規の方はこちら(会員登録画面へ)</a>
</body>
</html>