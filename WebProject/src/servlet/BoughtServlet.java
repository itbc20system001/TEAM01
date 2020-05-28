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
import javabeans.Product;
import model.PostOrderDescDAOLogic;
import model.PostOrderMainDAOLogic;

/**
 * Servlet implementation class BoughtServlet
 */
@WebServlet("/BoughtServlet")
public class BoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//セッションスコープ
		HttpSession session = request.getSession();
		HappyLife happyLife = (HappyLife) session.getAttribute("happy");

		happyLife.getP_Buy_List().clear();//カート内商品全消去

		RequestDispatcher dispatcher = request.getRequestDispatcher("tyuumon.jsp");
		dispatcher.forward(request, response);
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

		//ここから商品の数だけ繰り返し↓
		for (Product product : productList) {
			//セッションスコープからユーザーIDと商品番号の取得
			int userid = happy.getUserid();
			int productid = product.getP_id();


			//注文時間と有効期限の取得
			LocalDateTime ldt1 = LocalDateTime.now();//現在時刻
			LocalDateTime ldt2 = ldt1.plusDays(1);//有効期限(一日追加)

			//HappyLifeインスタンスを生成し注文内容をセット
			HappyLife hl = new HappyLife();
			hl.setUserid(userid);
			hl.setOrderDate(ldt1);
			hl.setLimitDate(ldt2);

			hl.setProductid(productid);


			//OrderMainDAOに処理を移して注文書テーブルにINSERT
			PostOrderMainDAOLogic pomdl = new PostOrderMainDAOLogic();
			pomdl.execute(hl);

			//OrderDescDAOに処理を移して注文明細テーブルにINSERT
			PostOrderDescDAOLogic poddl = new PostOrderDescDAOLogic();
			poddl.execute(hl);
		}
		//↑繰り返しここまで！！

/*		HappyCalcLogic未インポートのためエラー
 * ここから97行目までの内容をBuyServletにするかも？
		//残金の計算HappyCalcLogicメソッド呼び出し
		HappyCalcLogic hcl = new HappyCalcLogic();
		KouhukuPoint(仮) KP = hcl.BuyCalc();//

		if(KP.getOturi < 0) {
			HttpSession session2 = request.getSession();
			session2.setAttribute("KP", KP);
			RequestDispatcher dispatcher =request.getRequestDispatcher("kounyuerror.jsp");
			dispatcher.forward(request, response);
		}

		//ここでランダムでポイント付与するかも（その場合HappyCalcLogicで残金とガチャポイントを足す）

		//残りの幸福ポイント(おつり)をusrテーブルに登録
		HappyLife hl2 = new HappyLife();
		BalanceRegisterLogic brl = new BalanceRegisterLogic();
		hl2.setHappypoint(KP.getOturi());
		brl.execute(hl2);
*/

		//注文完了画面にフォワード
		/*RequestDispatcher dispatcher =request.getRequestDispatcher("tyuumon.jsp");
		dispatcher.forward(request, response);*/

	}

}
