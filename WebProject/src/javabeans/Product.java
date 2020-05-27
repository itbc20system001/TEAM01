package javabeans;

public class Product {
	private int p_id;
	private String p_name;
	private int price;

	public Product(int p_id, String p_name, int price) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.price = price;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
