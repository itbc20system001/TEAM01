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

	public ArrayList<Product> loadingProduct() {
		ArrayList<Product> productList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {

			String sql = "SELECT p_id,p_name,price FROM product ORDER BY DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs =  pStmt.executeQuery();

			while(rs.next()) {
				int p_id=rs.getInt("p_id");
				String p_name=rs.getString("p_name");
				int price = rs.getInt("price");
				Product product =new Product(p_id,p_name,price);
				productList.add(product);
			}
			/*pStmt.setInt(1, happylife.getProductid());
					pStmt.setInt(2, happylife.getUserid());
					pStmt.setDate(3, happylife.getOrderDate());//注文確定ボタンを押したときの時間をorderdateに代入
					pStmt.setDate(4, happylife.getLimitDate());//その後24時間後を足す
			 */


		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return productList;
	}









}
