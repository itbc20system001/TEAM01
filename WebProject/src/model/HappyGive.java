package model;

import java.util.Random;

import javabeans.Register;

//ロジック：happypointのランダム生成クラス
public class HappyGive {

	public int pointExcute() {
		//happypointランダム生成
		int sum = (int) (Math.random() * 100) + 30;
		//javabeansにランダム生成された値をセット
		return sum;
	}
	public int pointExcute(Register register) {
		//happypointランダム生成
		Random rnd = new Random();
		int[] happySeed = new int[10];

		try {
			happySeed[0] = rnd.nextInt(register.getL_name().length()) + 10000;
			happySeed[1] = rnd.nextInt(register.getF_name().length());
			happySeed[2] = rnd.nextInt(register.getL_name_kana().length());
			happySeed[3] = rnd.nextInt(register.getF_name_kana().length());
			happySeed[4] = rnd.nextInt(register.getPrefecture().length());
			happySeed[5] = rnd.nextInt(register.getCity().length());
			happySeed[6] = rnd.nextInt(register.getO_address().length());
			happySeed[7] = rnd.nextInt(register.getTel().length());
			happySeed[8] = rnd.nextInt(register.getEmail().length());
			happySeed[9] = rnd.nextInt(register.getBirthday().length());
			int sum = 0;
			//合計を足して返す
			for (int i : happySeed) {
				sum += i;
			}
			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			return 10000;
		}
	}
}
