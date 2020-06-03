<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
	Register register = (Register) request.getAttribute("register");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜会員情報の表示</title>
<style type="text/css">
hr {
  border-color: darkred;
}
.info {
	border-collapse: collapse;
}

.info th, .info td {
	padding: 8px;
	border-bottom: 1px solid #800000;
	text-align: left;
}
</style>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
   <h2>ご登録情報の確認</h2>
   <hr>
  <h3><%=happyLife.getUsrName()%>さんの会員情報
  </h3>

  <table class="info">
    <tr>
      <th>氏名</th>
      <td><%=register.getL_name()%><%=register.getF_name()%>さん</td>
    </tr>
    <tr>
      <th>氏名(カナ)</th>
      <td><%=register.getL_name_kana()%><%=register.getF_name_kana()%>さん</td>
    </tr>
    <tr>
      <th>お住まいの地域</th>
      <td><%=register.getPrefecture()%><%=register.getCity()%></td>
    </tr>
    <tr>
      <th>お誕生日</th>
      <td><%=register.getBirthday()%></td>
    </tr>
    <tr>
      <th>電話番号</th>
      <td><%=register.getTel()%></td>
    </tr>
    <tr>
      <th>メールアドレス</th>
      <td><%=register.getEmail()%></td>
    </tr>
    <tr>
      <th>現在の幸福ポイント</th>
      <td><%=happyLife.getHappypoint()%>KP</td>
    </tr>
  </table>
  <p>
    <a href=MyPage>マイページへ戻る</a>
  </p>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>