package model;

import dao.UsrDAO;
import javabeans.HappyLife;

public class BalanceRegisterLogic {
	public void execute(HappyLife happylife) {
		UsrDAO usrdao = new UsrDAO();
		usrdao.create2(happylife);
	}

}
