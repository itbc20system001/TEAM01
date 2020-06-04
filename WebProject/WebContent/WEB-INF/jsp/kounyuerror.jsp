<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%int lacky=(int)(Math.random()*3); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜購入エラー</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
  <p>幸福ポイントが不足しているため、商品を購入できませんでした。</p>
  <%if(true){ %>
  <p>幸福ポイントがマイナスになってしまいますが、それでも購入しますか？</p>
  <form action="Buy" method="POST">
  <input type="submit" value="はい" name="go">
  <input type="submit" value="いいえ" name="go">
  </form>
<%} %>
  <p>
    <a href="Product">商品一覧へ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>