package javabeans;

import java.io.Serializable;

public class Payment implements Serializable{

	private int sum;//購入金額！
	private int change;//おつり
	private int point;//購入後のキャッシュバックポイント

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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}


}
