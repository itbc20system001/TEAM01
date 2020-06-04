package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javabeans.Product;

public class ProductDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";

	//商品をリストに
	public ArrayList<Product> loadingProduct() {
		ArrayList<Product> productList = new ArrayList<>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {

			String sql = "select * from product";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs =  pStmt.executeQuery();

			while(rs.next()) {
				int p_id=rs.getInt("p_id");
				String p_name=rs.getString("p_name");
				int price = rs.getInt("price");
				Product product =new Product(p_id,p_name,price);
				productList.add(product);
			}

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return productList;
	}









}
