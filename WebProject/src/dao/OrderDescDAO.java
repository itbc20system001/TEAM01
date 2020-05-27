package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javabeans.HappyLife;

public class OrderDescDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";//仮
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";

	public OrderDescDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			Class.forName("org.mariadb.jdbc.Driver");//仮
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public boolean create(HappyLife happylife) {
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "INSERT INTO ORDER_DESC(PO_ID, P_id) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, happylife.getPo_id());//po_idの取得と設定。
			pStmt.setInt(2, happylife.getProductid());//p_idの取得と設定。

			//INSERT文の実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
