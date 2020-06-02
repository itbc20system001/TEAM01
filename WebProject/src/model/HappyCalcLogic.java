package model;

import javabeans.HappyLife;
import javabeans.Payment;

//商品の購入計算（ロジック）

public class HappyCalcLogic {

	public Payment buyCalc() {

		//現在のユーザーのhappypointを取得
		HappyLife h = new HappyLife();
		int usrHappy = h.getHappypoint();

		//購入金額とおつりを計算
		int sum = 0;
		for (int i = 0; i < h.getP_Buy_List().size(); i++) {
			sum += h.getP_Buy_List().get(i).getPrice();
		}
		int change = usrHappy - sum;
		usrHappy -= sum;

		//購入計算処理後の情報を格納するjavabeansを生成。→処理結果をセット
		Payment paymentInfo = new Payment();
		paymentInfo.setSum(sum);
		paymentInfo.setChange(change);

		return paymentInfo;
	}

	//セッションスコープ内のモノを活用できるように変更
	public Payment buyCalc(HappyLife happyLife) {

		//現在のユーザーのhappypointを取得
		int usrHappy = happyLife.getHappypoint();

		//購入金額とおつりを計算
		int sum = 0;
		for (int i = 0; i < happyLife.getP_Buy_List().size(); i++) {
			sum += happyLife.getP_Buy_List().get(i).getPrice();
		}
		int change = usrHappy - sum;
		usrHappy -= sum;

		//購入計算処理後の情報を格納するjavabeansを生成。→処理結果をセット
		Payment paymentInfo = new Payment();
		paymentInfo.setSum(sum);
		paymentInfo.setChange(change);

		return paymentInfo;
	}

	//購入後のポイントキャッシュバック
	public  double cashBack(Payment p) {
		//購入金額を取得
		double point = 0;
		int sum1 = p.getSum();
		if(sum1 <= 24150 && sum1 > 15000) {
			return point = sum1 * 0.6;
		}else if (sum1 <= 15000 && sum1 > 10000) {
			return point = sum1 * 0.5;
		}else if (sum1 <= 10000 && sum1 > 5000) {
			return point = sum1 * 0.4;
		}else if(sum1 <= 5000 && sum1 > 3000) {
			return point = sum1 * 0.3;
		}else if(sum1 <= 3000 && sum1 > 1000) {
			return point = sum1 * 0.2;
		}else {
			System.out.println(sum1*0.1);
			return point = sum1 * 0.1;
		}

	}

	//占い
	public HappyLife uranai(HappyLife happyLife) {
		int kekka = (int)(Math.random()*100)+1;
		int KP = 0;
		if(kekka <= 100 && kekka > 75) {
			//凶
			//現在持っているKPに－20
			happyLife.setMessage("凶");
		    KP-=20;
		}else if(kekka <= 75 && kekka > 50) {
			//小吉
			//KP－10
			happyLife.setMessage("小吉");
			KP-=10;

		}else if(kekka <= 50 && kekka > 25) {
			//中吉
			//KP+10
			happyLife.setMessage("中吉");
			KP+=10;
		}else {
			//大吉
			//KP+20
			happyLife.setMessage("大吉");
			KP+=20;
		}
		System.out.println(happyLife.getMessage());
		happyLife.setKP(KP);
		return happyLife;
	}

}
