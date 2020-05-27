package model;

import dao.OrderMainDAO;
import javabeans.HappyLife;

public class PostOrderMainDAOLogic {
	public void execute(HappyLife happylife) {
		OrderMainDAO omd = new OrderMainDAO();
		omd.create(happylife);

	}

}
