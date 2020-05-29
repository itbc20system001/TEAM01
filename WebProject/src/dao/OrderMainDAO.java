package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javabeans.HappyLife;

public class OrderMainDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";

	public boolean create(HappyLife happylife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {

			String sql = "INSERT INTO order_main(usr_id,order_date,limit_date) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			//現在時刻と有効期限の型をsql.dateに変換
			LocalDateTime god = happylife.getOrderDate();
			java.sql.Timestamp javaSqlDate = java.sql.Timestamp.valueOf(god);
			LocalDateTime gld = happylife.getLimitDate();
			java.sql.Timestamp javaSqlDate2 = java.sql.Timestamp.valueOf(gld);

			//productID(po_id)はauto_incrementなので不要
			pStmt.setInt(1, happylife.getUserid());
			pStmt.setTimestamp(2, javaSqlDate);//注文確定ボタンを押したときの時間をorderdateに代入
			pStmt.setTimestamp(3, javaSqlDate2);//その後24時間後を足す
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public HappyLife poIdCheck (HappyLife happyLife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select po_id from order_main where order_date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			LocalDateTime god = happyLife.getOrderDate();
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//java.sql.Timestamp javaSqlDate = java.sql.Timestamp.valueOf(god);
			pStmt.setString(1, god.format(f));

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int po_id = rs.getInt("po_id");
				happyLife.setPo_id(po_id);
				return happyLife;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return happyLife;
	}
}
