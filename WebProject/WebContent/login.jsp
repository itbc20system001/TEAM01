<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜ログイン</title>
<link rel="stylesheet" href="kohukudo.css">
<style type="text/css">
td {
  padding: 4px;
}
</style>
</head>
<body>
  <header>

    <h1 style="text-align: center">
      <a href="TOP"><img src="image/kohukudo_logo_touka.png" alt="kohukudo"></a>
    </h1>
  </header>
  <h2>ログイン</h2>
  <hr>
  <h3>メールアドレスとパスワードを入力してください</h3>
  <table>
    <form action="Login" method="post">
      <tr>
        <td>メールアドレス</td>
        <td><input type="text" name="email"><br></td>
      </tr>
      <tr>
        <td>パスワード</td>
        <td><input type="password" name="pass"> <br></td>
      </tr>
  </table>
  <input type="submit" value="ログイン">
  </form>
  <p>
    <a href="Register">ご新規の方はこちら(会員登録画面へ)</a>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>