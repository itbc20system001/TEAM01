package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Payment;
import model.HappyCalcLogic;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//そのまま購入する場合の処理
		//購入金額を計算するロジックを呼ぶ処理
		request.setCharacterEncoding("UTF-8");
		HappyCalcLogic hcl = new HappyCalcLogic();
		Payment p = hcl.buyCalc();

		HttpSession session = request.getSession();
		session.setAttribute("payment", p);

		RequestDispatcher dispatcher = request.getRequestDispatcher("kakunin.jsp");
		dispatcher.forward(request, response);

		/*	作業途中
		 * 購入が取りやめになった場合の処理（２回目以降に呼ばれる処理）
				確認jsp画面で、購入を取りやめた場合
					セッションスコープに入っているpaymentを削除してcart.jspに遷移する処理
					request.setCharacterEncoding("UTF-8");

					HttpSession session = request.getSession();
					session.removeAttribute("payment");
					RequestDispatcher dispatcher =request.getRequestDispatcher("cart.jsp");
					dispatcher.forward(request, response);*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
