<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javabeans.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.LinkedHashSet"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%
    ArrayList<HappyLife> ordered = (ArrayList) request.getAttribute("order");
	HappyLife happyLife = (HappyLife) session.getAttribute("happy");
	Payment payment = (Payment) session.getAttribute("payment");
	ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    int limit_over=0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>幸福堂｜注文内容確認</title>
</head>
<body>
  <header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
  </header>
<table>
  <%
  	for (int k = 0; k < happyLife.getP_Buy_List().size(); k++) {
  %>
  <tr>
  <td><%=happyLife.getP_Buy_List().get(k).getP_name()%></td>
    <td>:<%=happyLife.getP_Buy_List().get(k).getPrice()%>KP</td>

    <%
      for (int i = 0; i < happyLife.getOrdered_List().size(); i++) {
    %>
    <%if(productList.get(i).getP_name().contains(happyLife.getP_Buy_List().get(k).getP_name())){%>


    <%
        for (int j = 0; j < ordered.size(); j++) {
            if (ordered.get(j).getPo_id() == happyLife.getPo_id_List().get(i)&&!now.isAfter(ordered.get(j).getLimitDate())) {
              limit_over++;
      %>
    <td>残り有効期限：</td>

    <td><%=ordered.get(j).getLimitDate().format(f)%>まで</td>
    <%
        }
        }
      }
      }
    %>
  </tr>
  <%
  	}
  %>
  </table>
  <p>
    購入前:<%=happyLife.getHappypoint()%>KP<br> 購入後:<%=payment.getChange()%>KP
  </p>
  <%if(limit_over>0){ %>
<h3>有効期限が残っている商品がカートに入っています！本当によろしいですか？</h3>
<%} %>
  <a href=Bought>購入確定</a>
  <br>
  <a href=Cart>戻る</a>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>