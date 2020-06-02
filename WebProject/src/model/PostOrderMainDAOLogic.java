package model;

import java.util.ArrayList;

import dao.OrderMainDAO;
import javabeans.HappyLife;

public class PostOrderMainDAOLogic {
	public void execute(HappyLife happylife) {
		OrderMainDAO omd = new OrderMainDAO();
		omd.create(happylife);

	}
	public HappyLife poIdExecute (HappyLife happyLife) {
		OrderMainDAO omd = new OrderMainDAO();
		return omd.poIdCheck(happyLife);
	}
	public ArrayList<HappyLife> getMainExecute (HappyLife happyLife){
		OrderMainDAO omd = new OrderMainDAO();
		return omd.getMainOrder(happyLife);
	}

}
