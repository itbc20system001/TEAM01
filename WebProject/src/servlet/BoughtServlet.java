package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.HappyLife;

/**
 * Servlet implementation class BoughtServlet
 */
@WebServlet("/BoughtServlet")
public class BoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =request.getRequestDispatcher("tyuumon.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープに保存された商品情報を取得
		HttpSession session = request.getSession();
		HappyLife 商品情報の名前 = (HappyLife)session.getAttribute("商品情報の名前");


		//セッションスコープから商品IDとユーザーIDの取得
		int productid = 商品情報の名前.getProductid();
		int userid = 商品情報の名前.getUserid();

		//注文時間と有効期限の取得
		LocalDateTime ldt1 = LocalDateTime.now();//現在時刻
		LocalDateTime ldt2 = ldt1.plusDays(1);//有効期限(一日追加)

		//HappyLifeインスタンスを生成し注文内容をセット
		HappyLife hl = new HappyLife();
		hl.setProductid(productid);
		hl.setUserid(userid);
		hl.setOrderDate(ldt1);
		hl.setLimitDate(ldt2);

	}

}
