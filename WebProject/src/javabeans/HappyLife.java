package javabeans;

import java.io.Serializable;

public class HappyLife implements Serializable {

	private int happypoint;//KP
	private int price;//値段
	private int productid;//p_idを入れる予定
	private String usrName;//ユーザーネーム

	public int getHappypoint() {
		return happypoint;
	}

	public void setHappypoint(int happypoint) {
		this.happypoint = happypoint;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
}
