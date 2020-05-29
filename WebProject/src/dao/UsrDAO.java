package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabeans.HappyLife;
import javabeans.Register;

public class UsrDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mariadb://localhost/kohukudo";
	private final String DB_USER = "root";
	private final String DB_PASS = "insource.2015it";

	//現在未使用
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
			String sql = "INSERT INTO USR(L_NAME,F_NAME,L_NAME_KANA,F_NAME_KANA,PREFECTURE,CITY,O_ADDRESS,TEL,EMAIL,BIRTHDAY,PASSWORD) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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

	//現在使用中
	public boolean create(HappyLife happylife, Register register) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "INSERT INTO USR(L_NAME,F_NAME,L_NAME_KANA,F_NAME_KANA,PREFECTURE,CITY,O_ADDRESS,TEL,EMAIL,BIRTHDAY,PASSWORD,HAPPY) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pStmt.setInt(12, happylife.getHappypoint());

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

	public boolean isEmail(Register register) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "select email, password from usr where email = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, register.getEmail());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String email = rs.getString("email");
				if (email.equals(register.getEmail())) {
					return true;
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean create2(HappyLife happylife) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "UPDATE usr SET HAPPY = ? WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, happylife.getHappypoint());
			pStmt.setInt(2, happylife.getUserid());

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

	public Register findUserInfo(Register reg, HappyLife happylife) {
		//既に登録されてある会員情報をデータベースから取得しRegister.javaにセットする処理
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "select * from usr where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, happylife.getUserid());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				//Register.javaに会員情報をセット

				String l_name = rs.getString("l_name");
				reg.setL_name(l_name);
				String f_name = rs.getString("f_name");
				reg.setF_name(f_name);
				String l_name_kana = rs.getString("l_name_kana");
				reg.setL_name_kana(l_name_kana);
				String f_name_kana = rs.getString("f_name_kana");
				reg.setF_name_kana(f_name_kana);
				String prefecture = rs.getString("prefecture");
				reg.setPrefecture(prefecture);
				String city = rs.getString("city");
				reg.setCity(city);
				String o_address = rs.getString("o_address");
				reg.setO_address(o_address);
				String tel = rs.getString("tel");
				reg.setTel(tel);
				String email = rs.getString("email");
				reg.setEmail(email);
				String birthday = rs.getString("birthday");
				reg.setBirthday(birthday);
				String password = rs.getString("password");
				reg.setPassword(password);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return reg;
	}
}
