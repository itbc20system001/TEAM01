package model;

import javabeans.HappyLife;
import javabeans.Payment;

//商品の購入（ロジック）
//①：商品情報・ユーザー情報の取得

//②：購入演算 returnで返すもの おつり・購入金額の２つ

public class HappyCalcLogic {

	public Payment  buyCalc() {
		//メソッド①：確認jsp用の「支払額」を算出。
		//メソッド②：注文完了画面用。購入演算処理をして「残金」を算出→リターン
		//「支払額」と「現在のユーザーの持ち金」の入ったjavabeansクラス(payment)の変数を返す

		//現在のユーザーのhappypointを取得
		HappyLife h = new HappyLife();
		int usrHappy = h.getHappypoint();

		//支払い情報を格納するjavabeansを生成
		Payment paymentInfo = new Payment();
		int s = paymentInfo.getSum();
		int c = paymentInfo.getChange();

		//ここから作業途中
		//arrayListからユーザーのカート情報を取得する処理
		//購入金額を計算する処理
		for (int i = 0; i < h.getP_Buy_List().size(); i++) {
			//sum += h.getP_Buy_List(i).getP_Price();
		}

		//支払額の算出
		c =s - usrHappy;

		//javabeansに処理結果をセットする処理
		paymentInfo.setSum(s);
		paymentInfo.setChange(c);

		return paymentInfo;
	}

}
