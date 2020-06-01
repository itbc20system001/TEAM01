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


@WebServlet("/Uranai")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HappyLife HappyLife;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uranai.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("TOP");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//占いから呼び出し
				HttpSession session = request.getSession();
				HappyLife happy = (HappyLife) session.getAttribute("happy");

				//happycalclogicインスタンスに引数としてhappyスコープを渡して計算前のKPをhappyにセット
				HappyCalcLogic hcl = new HappyCalcLogic();
				happy = hcl.uranai(happy);

				//リクエストスコープで計算前のKPを送る
				request.setAttribute("kp", happy.getKP());
				//セッションスコープで計算後のKPを送る
				happy.setHappypoint(happy.getHappypoint()+happy.getKP());

				//返ってきた計算結果をbalanceregisterlogicを使用してデータベース書き換え
				BalanceRegisterLogic brl = new BalanceRegisterLogic();
				brl.execute(happy);

				//その内容をフォワードorリダイレクトuranai.jsp
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/uranai.jsp");
				dispatcher.forward(request, response);
	}


}
