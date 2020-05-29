package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.HappyLife;
import model.BalanceRegisterLogic;
import model.HappyCalcLogic;


@WebServlet("/UranaiServlet")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HappyLife HappyLife;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//占いから呼び出し
		HttpSession session = request.getSession();
		HappyLife happy = (HappyLife) session.getAttribute("happy");
		//happycalclogicインスタンスに引数としてhappyスコープを渡して計算してその結果をhappyにセット
		HappyCalcLogic hcl = new HappyCalcLogic();
		happy= hcl.uranai(happy);

		//返ってきた計算結果をbalanceregisterlogicを使用してデータベース書き換え
		BalanceRegisterLogic brl = new BalanceRegisterLogic();
		brl.execute(happy);

		//その内容をフォワードorリダイレクト　uranai.jsp
		RequestDispatcher dispatcher =request.getRequestDispatcher("uranai.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
