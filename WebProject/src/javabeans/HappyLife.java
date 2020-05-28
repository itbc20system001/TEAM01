package javabeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class HappyLife implements Serializable {

	private int happypoint;//KP!
	private int price;//値段
	private int productid;//p_idを入れる予定
	private ArrayList<Product> p_Buy_List = new ArrayList<Product>();
	private String message;//何かしらのメッセージ(仮)
	private String usrName;//ユーザーネーム
	private int po_id;//注文番号
	private int userid;//ユーザーID
	private LocalDateTime orderDate;//注文時間
	private LocalDateTime limitDate;//有効期限


	public int getPo_id() {
		return po_id;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(LocalDateTime limitDate) {
		this.limitDate = limitDate;
	}


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


	public ArrayList<Product> getP_Buy_List() {
		return p_Buy_List;
	}

	public void setP_Buy_List(ArrayList<Product> p_Buy_List) {
		this.p_Buy_List = p_Buy_List;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
