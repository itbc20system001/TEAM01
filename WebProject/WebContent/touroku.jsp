<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>
<form action ="RegisterServlet" method="post">
利用者名（氏）<br><input type="text" name="l_name"><br><br>
利用者名（名）<br><input type="text" name="f_name"><br><br>
利用者名（氏カナ）<br><input type="text" name="l_name_kana"><br><br>
利用者名（名カナ）<br><input type="text" name="f_name_kana"><br><br>
住所（都道府県）<br><input type="text" name="prefecture"><br><br>
住所（市区町村名）<br><input type="text" name="city"><br><br>
住所（その他）<br><input type="text" name="o_address"><br><br>
電話番号<br><input type="text" name="tel"><br><br>
Eメールアドレス<br><input type="text" name="email"><br><br>
生年月日 ※西暦‐月‐日の形で入力<br><input type="text" name="birthday"><br><br>

<!-- 以下、日付プルダウンメニューのテスト 
<br>
<select name="year" id="id_year">
</select>
<select name="month" id="id_month">
</select>
<select name="day" id="id_day">
</select>
<script>
(function() {
  'use strict';


  var optionLoop, this_day, this_month, this_year, day;
  day = new Date();
  this_year = day.getFullYear();
  this_month = day.getMonth() + 1;
  this_day = day.getDate();

  /*
    ループ処理（スタート数字、終了数字、表示id名、デフォルト数字）
   */
  optionLoop = function(start, end, id, this_day) {
    var i, opt;

    opt = null;
    for (i = start; i <= end ; i++) {
      if (i === this_day) {
        opt += "<option value='" + i + "' selected>" + i + "</option>";
      } else {
        opt += "<option value='" + i + "'>" + i + "</option>";
      }
    }
    return document.getElementById(id).innerHTML = opt;
  };


  /*
    関数設定（スタート数字[必須]、終了数字[必須]、表示id名[省略可能]、デフォルト数字[省略可能]）
   */
  optionLoop(1900, this_year, 'id_year', this_year);
  optionLoop(1, 12, 'id_month', this_month);
  optionLoop(1, 31, 'id_day', this_day);
})();

</script>
<br>
 以上、日付プルダウンメニューのテスト -->

パスワード<br><input type="password" name="password"><br><br>
<input type="submit" value ="送信">
</form>

</body>
</html>