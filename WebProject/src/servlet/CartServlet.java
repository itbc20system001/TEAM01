package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.HappyLife;
import javabeans.Payment;
import javabeans.Product;
import model.HappyCalcLogic;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//購入金額を計算するロジックを呼ぶ処理
			request.setCharacterEncoding("UTF-8");
			HappyCalcLogic hcl = new HappyCalcLogic();
			//Payment payment = hcl.buyCalc();
			//セッションからhappyとpaymentを呼び、カートに来るごとにpaymentを逐次計算
			HttpSession session = request.getSession();
			Payment payment = (Payment) session.getAttribute("payment");
			HappyLife happyLife = (HappyLife) session.getAttribute("happy");
			payment = hcl.buyCalc(happyLife);
			//スコープpaymentを再定義
			session.setAttribute("payment", payment);

			System.out.println(payment.getChange());
			//System.out.println(payment.);

			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("top.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//削除ボタンが押された場合に指定の商品をカートから除く
		String cartOutName=request.getParameter("削除");
		HttpSession session = request.getSession();
		HappyLife happyLife =(HappyLife)session.getAttribute("happy");
		ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

		happyLife.getP_Buy_List();
		if(cartOutName.equals("シャワーをカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(0));
		}else if(cartOutName.equals("リモコンをカートから削除")){
			happyLife.getP_Buy_List().remove(productList.get(1));
		}else if(cartOutName.equals("行列をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(2));
		}else if(cartOutName.equals("信号をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(3));
		}
		doGet(request, response);
	}

}
