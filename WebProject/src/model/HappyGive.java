package model;

import javabeans.HappyLife;

//ロジック：happypointのランダム生成クラス
public class HappyGive {

	public void pointExcute() {

		HappyLife happylife = new HappyLife();

		//happypointランダム生成
		int h = (int) (Math.random() * 10000) + 1;
		//javabeansにランダム生成された値をセット
		happylife.setHappypoint(h);
	}
}
