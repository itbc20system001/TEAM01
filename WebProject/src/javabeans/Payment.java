package javabeans;

public class Payment {

	private int sum;//購入金額！
	private int change;//おつり
	private int temporaryHappy;//仮のKP.購入計算後のKPを一時的に格納.

	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	public int getTemporaryHappy() {
		return temporaryHappy;
	}
	public void setTemporaryHappy(int temporaryHappy) {
		this.temporaryHappy = temporaryHappy;
	}


}
