<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%int count=0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品1</title>
</head>
<body>
<table>
<th>商品1<br>100KP</th>
<tr>
<td><img src="image/kari.gif" width="300" height="300" alt="shouhin1"><td>
<td>商品1です。あなたに幸福とかあるでしょう。</td>
<tr>

</table>
<form>
<input type="button" value="購入" onclick="cartIn()">
<input type="button" value="確認" onclick="kari()">
</form>
</body>
<script>
var count=0;
var cartIn = function a() {
  alert('カートに追加しました');
  count++;
}
var kari = function b() {
  alert(count);
}
</script>
</html>