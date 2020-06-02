package model;

import dao.LoginDAO;
import javabeans.HappyLife;
import javabeans.Login;
import javabeans.Register;

public class LoginLogic {
	public boolean execute (Login login) {
		LoginDAO dao = new LoginDAO();
		return dao.create(login);
	}
	public HappyLife sessionExecute (Login login,HappyLife happyLife) {
		LoginDAO dao = new LoginDAO();
		return dao.sessionIn(login,happyLife);
	}
	public int LoginUserCheckExecute (Register register) {
		LoginDAO dao = new LoginDAO();
		return dao.LoginUserCheck(register);
	}
	public void LoginSetExecute (int id) {
		LoginDAO dao = new LoginDAO();
		boolean check= dao.LoginSet(id);
	}
	public void LoginCompleteExecute (Login login) {
		LoginDAO dao = new LoginDAO();
		boolean check= dao.LoginComplete(login);
	}
	public Login loginLoadExecute (Login login,HappyLife happyLife) {
		LoginDAO dao = new LoginDAO();
		return dao.loginLoad(login,happyLife);
	}
}
