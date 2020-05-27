package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabeans.Login;

public class LoginDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";

	public boolean create (Login login) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select email, password from usr where email = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getEmail());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}