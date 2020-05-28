package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javabeans.HappyLife;

public class OrderMainDAO {
	//データベース接続に使用する情報
			private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
			private final String DB_USER = "root";
			private final String DB_PASS = "insource.2015it";

			public boolean create(HappyLife happylife) {
				try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {

					String sql = "INSERT INTO order_main(NAME, TEXT) VALUES (?,?,?)";
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









}
