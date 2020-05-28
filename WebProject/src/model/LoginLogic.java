package model;

import dao.LoginDAO;
import javabeans.HappyLife;
import javabeans.Login;

public class LoginLogic {
	public boolean execute (Login login) {
		LoginDAO dao = new LoginDAO();
		return dao.create(login);
	}
	public HappyLife sessionExecute (Login login,HappyLife happyLife) {
		LoginDAO dao = new LoginDAO();
		return dao.sessionIn(login,happyLife);
	}

}
