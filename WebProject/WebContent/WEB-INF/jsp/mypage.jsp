<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜マイページ</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <ul>
    <li><a href=PurchaseHistory>購入履歴</a></li>
    <li><a href=UserInfo>会員情報</a></li>
    <li><a href=Uranai>占い</a></li>
  </ul>

  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>