<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜ログアウト確認</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  ログアウトしますか？
  <form action="Logout" name="logoutyn" method="POST">
    <button name="logoutyn" value="yes">はい</button>
    <button name="logoutyn" value="no">いいえ</button>
  </form>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>