<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javabeans.*"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%
	Payment payment = (Payment) session.getAttribute("payment");
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>
</head>
<body>

  <h2>注文が完了しました</h2>
  <p><%=payment.getPoint()%>ポイント獲得！！！
  </p>
  <p>
    購入後<%=payment.getChange()%>KP→キャッシュバック：<%=happyLife.getHappypoint()%>KP
  </p>
  <p>
    有効期限：<%=happyLife.getLimitDate().format(f)%>まで
  </p>
  <h3>あなたに幸福が訪れますように...</h3>

  <a href="kakushouhin.jsp">商品一覧へ</a>

</body>
</html>