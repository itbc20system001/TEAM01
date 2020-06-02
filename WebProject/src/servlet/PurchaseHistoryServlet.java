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
			HttpSession session = request.getSession();
			HappyLife happyLife = (HappyLife) session.getAttribute("happy");

			PostOrderMainDAOLogic  mainDao = new PostOrderMainDAOLogic();
			PostOrderDescDAOLogic  descDao = new PostOrderDescDAOLogic();

			//HashMap<Integer,HappyLife> ordered =new HashMap<Integer,HappyLife>();
			ArrayList<HappyLife> ordered = new ArrayList<HappyLife>();
			ordered= mainDao.getMainExecute(happyLife);
			for(int i = 0;i<ordered.size();i++) {
				ordered= descDao.getDescExecute(ordered,i);
			}
			ArrayList<Integer> ordered_List=new ArrayList<Integer>();
			ArrayList<Integer> po_id_List=new ArrayList<Integer>();

			for(int i=0;i<ordered.size();i++) {
				for(int j = 0;j<ordered.get(i).getOrdered_List().size();j++ ) {
					System.out.println("注文番号："+ordered.get(i).getPo_id());
					System.out.println("注文商品："+ordered.get(i).getOrdered_List().get(j));

					if(ordered_List.contains(ordered.get(i).getOrdered_List().get(j))) {
						int set = ordered_List.indexOf(ordered.get(i).getOrdered_List().get(j));
						ordered_List.remove(set);
						po_id_List.remove(set);
					}
						ordered_List.add(ordered.get(i).getOrdered_List().get(j));
						po_id_List.add(ordered.get(i).getPo_id());
				}
			}

			//ordered_List = new ArrayList<Integer>(new LinkedHashSet<>(ordered_List));
			for(int i = 0;i<ordered_List.size();i++ ) {
				System.out.println(ordered_List.get(i));
			}
			for(int i = 0;i<po_id_List.size();i++ ) {
				System.out.println(po_id_List.get(i));
			}

			happyLife.setOrdered_List(ordered_List);
			happyLife.setPo_id_List(po_id_List);

			request.setAttribute("order", ordered);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kounyurireki.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
