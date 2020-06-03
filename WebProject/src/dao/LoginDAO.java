package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javabeans.HappyLife;
import javabeans.Login;
import javabeans.Register;

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
	public HappyLife sessionIn (Login login,HappyLife happyLife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select user_id,l_name,happy from usr where email = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getEmail());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int user_id = rs.getInt("user_id");
				String l_name = rs.getString("l_name");
				int happypoint = rs.getInt("happy");
				happyLife.setUserid(user_id);
				happyLife.setUsrName(l_name);
				happyLife.setHappypoint(happypoint);
				//return happyLife;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return happyLife;
	}

	public int LoginUserCheck (Register register) {
		int user_id=0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select user_id from usr where email = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, register.getEmail());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				user_id = rs.getInt("user_id");

				//return happyLife;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return user_id;
	}

	public boolean LoginSet(int id) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "INSERT INTO login(user_id,login_count,buy_count,last_login) VALUES(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			LocalDateTime now = LocalDateTime.now();
			java.sql.Timestamp javaSqlDate = java.sql.Timestamp.valueOf(now);

			pStmt.setInt(1, id);
			pStmt.setInt(2, 0);
			pStmt.setInt(3, 0);
			pStmt.setTimestamp(4, javaSqlDate);

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
	public boolean LoginComplete(Login login) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "UPDATE login SET login_count = ?,last_login = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			java.sql.Timestamp javaSqlDate = java.sql.Timestamp.valueOf(login.getLast_login());

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, login.getLogin_count()+1);
			pStmt.setTimestamp(2,javaSqlDate);
			pStmt.setInt(3, login.getUser_id());

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

	public boolean BuyComplete(Login login) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "UPDATE login SET buy_count = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, login.getBuy_count());
			pStmt.setInt(2, login.getUser_id());

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

	public Login loginLoad (Login login,HappyLife happyLife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql = "select login_count,buy_count,last_login from login where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

			pStmt.setInt(1, happyLife.getUserid());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int login_count = rs.getInt("login_count");
				int buy_count = rs.getInt("buy_count");
				String last_login_base = rs.getString("last_login");
				LocalDateTime last_login=LocalDateTime.parse(last_login_base,f);
				login.setUser_id(happyLife.getUserid());
				login.setLogin_count(login_count);
				login.setBuy_count(buy_count);;
				login.setLast_login(last_login);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return login;
	}
}