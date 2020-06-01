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
@WebServlet("/Cart")
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

			//System.out.println(payment.getChange());
			//System.out.println(payment.);

			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("TOP");
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
		}else if(cartOutName.equals("退席判明をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(4));
		}else if(cartOutName.equals("ページジャンプをカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(5));
		}else if(cartOutName.equals("５秒で睡眠をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(6));
		}else if(cartOutName.equals("不眠をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(7));
		}else if(cartOutName.equals("ラベルをカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(8));
		}else if(cartOutName.equals("静電気をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(9));
		}else if(cartOutName.equals("自販をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(10));
		}else if(cartOutName.equals("花粉症をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(11));
		}else if(cartOutName.equals("じゃんけん必勝をカートから削除")) {
			happyLife.getP_Buy_List().remove(productList.get(12));
		}
		doGet(request, response);
	}

}
