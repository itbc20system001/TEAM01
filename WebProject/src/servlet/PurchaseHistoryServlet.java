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
import model.PostOrderDescDAOLogic;
import model.PostOrderMainDAOLogic;

/**
 * Servlet implementation class PurchaseHistoryServlet
 */
@WebServlet("/PurchaseHistory")
public class PurchaseHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseHistoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");

			//セッション
			HttpSession session = request.getSession();
			HappyLife happyLife = (HappyLife) session.getAttribute("happy");

			if(happyLife.getHappypoint()<0) {
				response.sendRedirect("-");
			}else {

				//DAO2つ起動
				PostOrderMainDAOLogic  mainDao = new PostOrderMainDAOLogic();
				PostOrderDescDAOLogic  descDao = new PostOrderDescDAOLogic();

				//HappyLife型リストを起動して
				//HashMap<Integer,HappyLife> ordered =new HashMap<Integer,HappyLife>();
				ArrayList<HappyLife> ordered = new ArrayList<HappyLife>();
				//購入した注文情報(注文番号・注文日・期限)をリストに
				ordered= mainDao.getMainExecute(happyLife);
				//どの商品を買ったかを取得
				//使用した注文番号回、その注文番号と照合する商品を入れる
				for(int i = 0;i<ordered.size();i++) {
					ordered= descDao.getDescExecute(ordered,i);
				}
				//Integer型のリストを2つ
				ArrayList<Integer> ordered_List=new ArrayList<Integer>();
				ArrayList<Integer> po_id_List=new ArrayList<Integer>();

				//二重forで最新の注文番号で購入している各商品を割り出す
				for(int i=0;i<ordered.size();i++) {
					for(int j = 0;j<ordered.get(i).getOrdered_List().size();j++ ) {
						//過去に買っている商品の場合、前にあるものをリストから消す
						if(ordered_List.contains(ordered.get(i).getOrdered_List().get(j))) {
							int set = ordered_List.indexOf(ordered.get(i).getOrdered_List().get(j));
							ordered_List.remove(set);
							po_id_List.remove(set);
						}
						//i番目の購入した商品を
						//System.out.println(ordered.get(i).getOrdered_List().get(j));
						ordered_List.add(ordered.get(i).getOrdered_List().get(j));
						po_id_List.add(ordered.get(i).getPo_id());
					}
				}

				happyLife.setOrdered_List(ordered_List);
				System.out.println(ordered_List);
				happyLife.setPo_id_List(po_id_List);

				request.setAttribute("order", ordered);


				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kounyurireki.jsp");
				dispatcher.forward(request, response);
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
