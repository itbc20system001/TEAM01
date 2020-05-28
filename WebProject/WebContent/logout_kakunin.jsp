<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認</title>
</head>
<body>
ログアウトしますか？
<form action="LogoutServlet" name="logoutyn" method="get">
<button name="logoutyn" value="yes">はい</button>
<button name="logoutyn" value="no">いいえ</button>
</form>
</body>
</html>