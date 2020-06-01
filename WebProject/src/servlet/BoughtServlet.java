package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
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
import model.BalanceRegisterLogic;
import model.HappyCalcLogic;
import model.PostOrderDescDAOLogic;
import model.PostOrderMainDAOLogic;

/**
 * Servlet implementation class BoughtServlet
 */
@WebServlet("/Bought")
public class BoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//セッションスコープからhappy
			HttpSession session = request.getSession();
			HappyLife happy = (HappyLife) session.getAttribute("happy");
			//なんでもよかったが今回はgetOrderDateがnullとなる場合のみdoPost
			//tyuumon.jspで更新連打を防ぐ
			if (happy.getOrderDate() == null) {
				doPost(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tyuumon.jsp");
				dispatcher.forward(request, response);
			}
			/*		//セッションスコープ
			HttpSession session = request.getSession();
			HappyLife happyLife = (HappyLife) session.getAttribute("happy");

			happyLife.getP_Buy_List().clear();//カート内商品全消去

			RequestDispatcher dispatcher = request.getRequestDispatcher("tyuumon.jsp");
			dispatcher.forward(request, response);*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("TOP");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープに保存された商品情報とユーザー情報を取得
		HttpSession session = request.getSession();
		ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("product");
		HappyLife happy = (HappyLife) session.getAttribute("happy");
		Payment payment = (Payment)session.getAttribute("payment");

		//購入可能なら
		if(payment.getChange() >= 0) {

			//ここから購入商品の数だけ繰り返し↓
			for(int i=0;i<happy.getP_Buy_List().size();i++) {//購入商品リストを回す
				//注文時間と有効期限の取得
				happy.setOrderDate(LocalDateTime.now());
				happy.setLimitDate(happy.getOrderDate().plusDays(1));
				happy.setProductid(happy.getP_Buy_List().get(i).getP_id());

				//OrderMainDAOに処理を移して注文書テーブルにINSERT
				PostOrderMainDAOLogic pomdl = new PostOrderMainDAOLogic();

				pomdl.execute(happy);
				happy = pomdl.poIdExecute(happy);

				//OrderDescDAOに処理を移して注文明細テーブルにINSERT
				PostOrderDescDAOLogic poddl = new PostOrderDescDAOLogic();
				poddl.execute(happy);
			}
			//↑繰り返しここまで！！



			//ランダムでポイントキャッシュバック
			HappyCalcLogic hcl = new HappyCalcLogic();
			int point = (int)hcl.cashBack(payment);
			int zankin = payment.getChange()+point;

			//残りの幸福ポイント(おつり)をusrテーブルに登録
			BalanceRegisterLogic brl = new BalanceRegisterLogic();
			happy.setHappypoint(zankin);
			brl.execute(happy);

			payment.setPoint(point);

			//注文完了画面にフォワード
			happy.getP_Buy_List().clear();//カート内商品全消去
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/tyuumon.jsp");
			dispatcher.forward(request, response);

		}else {//エラー画面にフォワード
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/kounyuerror.jsp");
			dispatcher.forward(request, response);
		}

	}

}
