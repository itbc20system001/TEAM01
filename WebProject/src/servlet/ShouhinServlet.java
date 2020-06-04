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

/**
 * Servlet implementation class ShouhinServlet
 */
@WebServlet("/Shouhin")
public class ShouhinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShouhinServlet() {
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
			HappyLife happyLife =(HappyLife)session.getAttribute("happy");
			//マイナス送り
			if(happyLife.getHappypoint()<0) {
				response.sendRedirect("-");
			}else {

				String shouhin=request.getParameter("商品");
				//商品番号セット
				if(shouhin!=null) {
					int selecter = Integer.parseInt(shouhin);
					happyLife.setProductid(selecter);
				}
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/"+shouhin+".jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/shouhin.jsp");

				dispatcher.forward(request, response);
			}
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
		doGet(request, response);
	}

}
