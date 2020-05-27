package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javabeans.HappyLife;
import javabeans.Register;

public class UsrDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";


	public boolean create(Register register) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql =
					"INSERT INTO USR(L_NAME,F_NAME,L_NAME_KANA,F_NAME_KANA,PREFECTURE,CITY,O_ADDRESS,TEL,EMAIL,BIRTHDAY,PASSWORD) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, register.getL_name());
			pStmt.setString(2, register.getF_name());
			pStmt.setString(3, register.getL_name_kana());
			pStmt.setString(4, register.getF_name_kana());
			pStmt.setString(5, register.getPrefecture());
			pStmt.setString(6, register.getCity());
			pStmt.setString(7, register.getO_address());
			pStmt.setString(8, register.getTel());
			pStmt.setString(9, register.getEmail());
			pStmt.setString(10, register.getBirthday());
			pStmt.setString(11, register.getPassword());

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


	public boolean create(HappyLife happylife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql =
					"INSERT INTO USR(HAPPYPOINT) VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, happylife.getHappypoint());


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


