package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabeans.Login;
import javabeans.Register;

public class LoginDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = 
			"jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";
	
	//ここよくわかりませんでした
	public Login findByLogin(Login login) {
		Register register = null;
		return null;
	}
	public boolean create (Login login) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select email, password from usr where email = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getEmail());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String Email = rs.getString("email");
				String Password = rs.getString("password");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}