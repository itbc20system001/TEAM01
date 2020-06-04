<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>幸福堂｜新規会員登録</title>
<style type="text/css">
hr {
	border-color: darkred;
}
form div{
    padding:12px;
    border-bottom:1px dashed darkred;
}
 input[type="submit"]{
    padding:12px;
    width:150px;
    box-sizing:border-box;
}
 input[type="text"]{
    width:150px;
    height:1.5em;
    box-sizing:border-box;
}
 input[type="password"]{
    width:150px;
    height:1.5em;
    box-sizing:border-box;
}
select{
    width:150px;
    height:2em;
    box-sizing:border-box;
}
</style>
</head>
<body>
  <header>
    <link rel="stylesheet" href="kohukudo.css">
    <h1 style="text-align: center">
      <a href="TOP"><img src="image/headerimage/幸福堂ロゴ_login.png" alt="kohukudo"></a>
    </h1>
  </header>
  <h2>新規会員登録フォーム</h2>
  <hr>
  <h3>
    必要事項を入力してください<br> ※全項目は必須記入事項です<br>※「Eメールアドレス」と「パスワード」はログイン時に必要なものとなります。
  </h3>
  <form action="Register" method="post">
    <div><label>利用者名<br>姓：<input type="text" name="l_name"> 名：<input type="text" name="f_name"><br></label> </div>
    <div><label>利用者名（カナ）<br> 姓：<input type="text" name="l_name_kana"> 名：<input type="text" name="f_name_kana"><br></label> </div>
    <div><label> 住所（都道府県）<br> <!-- <input type="text" name="prefecture"> --> <select name="prefecture">
        <option value="" selected>都道府県</option>
        <option value="北海道">北海道</option>
        <option value="青森県">青森県</option>
        <option value="岩手県">岩手県</option>
        <option value="宮城県">宮城県</option>
        <option value="秋田県">秋田県</option>
        <option value="山形県">山形県</option>
        <option value="福島県">福島県</option>
        <option value="茨城県">茨城県</option>
        <option value="栃木県">栃木県</option>
        <option value="群馬県">群馬県</option>
        <option value="埼玉県">埼玉県</option>
        <option value="千葉県">千葉県</option>
        <option value="東京都">東京都</option>
        <option value="神奈川県">神奈川県</option>
        <option value="新潟県">新潟県</option>
        <option value="富山県">富山県</option>
        <option value="石川県">石川県</option>
        <option value="福井県">福井県</option>
        <option value="山梨県">山梨県</option>
        <option value="長野県">長野県</option>
        <option value="岐阜県">岐阜県</option>
        <option value="静岡県">静岡県</option>
        <option value="愛知県">愛知県</option>
        <option value="三重県">三重県</option>
        <option value="滋賀県">滋賀県</option>
        <option value="京都府">京都府</option>
        <option value="大阪府">大阪府</option>
        <option value="兵庫県">兵庫県</option>
        <option value="奈良県">奈良県</option>
        <option value="和歌山県">和歌山県</option>
        <option value="鳥取県">鳥取県</option>
        <option value="島根県">島根県</option>
        <option value="岡山県">岡山県</option>
        <option value="広島県">広島県</option>
        <option value="山口県">山口県</option>
        <option value="徳島県">徳島県</option>
        <option value="香川県">香川県</option>
        <option value="愛媛県">愛媛県</option>
        <option value="高知県">高知県</option>
        <option value="福岡県">福岡県</option>
        <option value="佐賀県">佐賀県</option>
        <option value="長崎県">長崎県</option>
        <option value="熊本県">熊本県</option>
        <option value="大分県">大分県</option>
        <option value="宮崎県">宮崎県</option>
        <option value="鹿児島県">鹿児島県</option>
        <option value="沖縄県">沖縄県</option>
    </select></label></div>
    <div><label>住所（市区町村名）<br> <input type="text" name="city"><br> </label></div>
     <div><label>住所（その他）<br> <input type="text" name="o_address"><br> </label></div>
     <div><label>電話番号<br> <input type="text" name="tel"><br> </label></div>
     <div><label>Eメールアドレス<br> <input type="text" name="email"><br></label></div>
     <div><label> 生年月日
    <!-- <input type="text" name="birthday"> -->


    <br> <select name="year" id="id_year">
    </select> <select name="month" id="id_month">
    </select> <select name="day" id="id_day">
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
              for (i = start; i <= end; i++) {
                if (i === this_day) {
                  opt += "<option value='" + i + "' selected>" + i
                      + "</option>";
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
        </script></label></div>
   <div><label>新規パスワード<br> <input type="password" name="password"><br> </label></div>
   <div><label><h3>ご入力内容に誤りはございませんか？</h3>
    <input type="submit" value="新規会員登録"></div></label>
  </form>
  <footer>
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
  </footer>
</body>
</html>