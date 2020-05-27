package model;

import dao.LoginDAO;
import javabeans.Login;

public class LoginLogic {
	public boolean execute (Login login) {
		LoginDAO dao = new LoginDAO();
//		login = dao.findByLogin(login);
		return login != null;
	}
}
