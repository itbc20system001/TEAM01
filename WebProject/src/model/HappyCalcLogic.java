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


	//購入後のポイントキャッシュバック
	public int cashBack() {
		int point = (int) (Math.random()*10000);

		Payment paymentInfo = new Payment();
		paymentInfo.setPoint(point);

		return point;
	}

}
