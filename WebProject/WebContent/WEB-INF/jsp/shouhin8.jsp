<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜眠らなくても疲れない</title>
<jsp:include page="header.jsp"/>
</head>
<body>
  <table>
    <th>眠らなくても疲れない<br><%=productList.get(7).getPrice()%>KP
    </th>
    <tr>
      <td><img src="image/睡眠不要.png" width="300" height="300" alt="shouhin5">
      <td>
      <td>「やっと課題が終わったけれど今から寝たら遅刻が確定する…。」<br>
<br>
こういう経験、ありませんか？<br>
<br>
かと言って徹夜すると体調が悪くなってしまいます。<br>
<br>
この商品をご購入いただけると、<br>
一日間は睡眠をとらずとも全く疲労しません。<br>
<br>
ただ、継続購入にはご注意を。<br>
効果が切れた際に一気に疲れが襲ってきます…。</td>
    <tr>
  </table>

  <%
  	if (!happyLife.getP_Buy_List().contains(productList.get(7))) {
  %>
  <form action="Product" method="POST">
    <input type="submit" value="<%=productList.get(7).getP_name()%>を購入" name="購入" onclick="cartIn()">
  </form>
  <%
  	} else {
  %>
  カートに入っています
  <%
  	}
  %>
    <jsp:include page="footer.jsp"/>
</body>
<script>
  var cartIn = function a() {
    alert('カートに追加しました');
  }
</script>
</html>