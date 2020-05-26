<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>
<form action ="RegisterServlet" method="post">
利用者名（氏）：<input type="text" name="l_name"><br>
利用者名（名）：<input type="text" name="f_name"><br>
利用者名（氏カナ）：<input type="text" name="l_name_kana"><br>
利用者名（名カナ）：<input type="text" name="f_name_kana"><br>
住所（都道府県）：<input type="text" name="prefecture"><br>
住所（市町村名）：<input type="text" name="city"><br>
住所（その他）：<input type="text" name="o_address"><br>
電話番号：<input type="text" name="tel"><br>
Eメールアドレス：<input type="text" name="email"><br>
生年月日：<input type="text" name="birthday"><br>
パスワード：<input type="text" name="password"><br>
<input type="submit" value ="送信">
</form>

</body>
</html>