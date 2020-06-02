package model;

import java.util.ArrayList;

import dao.OrderDescDAO;
import javabeans.HappyLife;

public class PostOrderDescDAOLogic {
	public void execute(HappyLife happylife) {
		OrderDescDAO odd = new OrderDescDAO();
		odd.create(happylife);
	}
	public ArrayList<HappyLife> getDescExecute(ArrayList<HappyLife>ordered ,int i) {
		OrderDescDAO odd = new OrderDescDAO();
		return odd.getDescOrder(ordered,i);
	}

}
