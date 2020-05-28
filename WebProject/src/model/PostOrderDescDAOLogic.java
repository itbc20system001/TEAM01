package model;

import dao.OrderDescDAO;
import javabeans.HappyLife;

public class PostOrderDescDAOLogic {
	public void execute(HappyLife happylife) {
		OrderDescDAO odd = new OrderDescDAO();
		odd.create(happylife);
	}

}
