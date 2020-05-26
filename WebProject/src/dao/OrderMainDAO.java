package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javabeans.HappyLife;

public class OrderMainDAO {
	//データベース接続に使用する情報
			private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
			private final String DB_USER = "root";
			private final String DB_PASS = "insource.2015it";

			public boolean creat(HappyLife happylife) {
				try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {

					String sql = "INSERT INTO order_main(NAME, TEXT) VALUES (?,?,?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					pStmt.setInt(1, happylife.getProductid());
					pStmt.setInt(2, happylife.getUserid());
					pStmt.setDate(3, happylife.getOrderDate());//注文確定ボタンを押したときの時間をorderdateに代入
					pStmt.setDate(4, happylife.getLimitDate());//その後24時間後を足す

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









}
