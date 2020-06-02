<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabeans.*"%>
<%HappyLife happyLife =(HappyLife)session.getAttribute("happy"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜TOP</title>

</head>

<body>
<header>
<%
try{
if(happyLife.getUsrName()!=null){%>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<% }
}catch(Exception e){
  e.printStackTrace();%>
<link rel="stylesheet" href="/kohukudo/kohukudo.css">
<h1 style="text-align:center"><a href="TOP"><img src="image/headerimage/幸福堂ロゴ_new.png" alt="kohukudo"></a></h1>

  <% }
%>
</header>
<h2 style="text-align:center">幸福について</h2>
<p style="text-align:center">「幸福」とは、何でしょうか？幸福には十人十色の形があります。<br>
美味しいものを食べる、ぐっすり眠る、恋人と一緒に過ごす…。<br>
一般的な幸福とは、概ねこのような形態ですよね。<br>
<br>
しかし、普段は意識しない思わぬところにも、幸福は存在しているものなのです。
<br>
テレビのリモコンがすぐに見つかる。<br>
駅までの道のりで信号に引っかからない。<br>
混雑した電車で座ることができる。<br>
<br>
いかがでしょう？少しだけ「ラッキー！」と感じませんか？<br>
<br>
我々『株式会社ハッピーライフ』は、皆様にささやかな幸せを提供させていただく事業を行っております。<br>
<br>
安心してください。<br>
お金は一切いただきません。<br>
<br>
何故ならば、幸福とはお金では買えぬものなのですから…。<br>
<br>
<%
try{
if(happyLife.getUsrName()!=null){%>
  <a href="Product">商品一覧画面</a>
<% }
}catch(Exception e){
  e.printStackTrace();%>
<a href="Login">ログイン画面へ</a><br>
<a href="Register">新規会員登録</a><br>
<% }
%>


</p>
<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>
</body>

</html>