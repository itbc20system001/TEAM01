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
import model.BalanceRegisterLogic;
import model.RegisterLogic;

/**
 * Servlet implementation class BrowserCrashServlet
 */
@WebServlet("/-")
public class BrowserCrashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowserCrashServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub

			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			HappyLife happy = new HappyLife();
			HappyLife happyLife = (HappyLife)session.getAttribute("happy");
			if(happyLife.getHappypoint()==-48484848) {
				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/happyhappy.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("-");
			}else {
			RegisterLogic registerLogic = new RegisterLogic();
			ArrayList<HappyLife> happyUser = registerLogic.happyBreakExcute(happy);
			session.setAttribute("happyuser", happyUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crash.jsp");
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String lastChoice = request.getParameter("go");
		if(lastChoice.equals("はい")) {
		BalanceRegisterLogic balanceRegisterLogic = new BalanceRegisterLogic();
		HappyLife happyLife = (HappyLife) session.getAttribute("happy");
		happyLife.setHappypoint(-48484848);
		balanceRegisterLogic.execute(happyLife);
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/happyhappy.jsp");
		dispatcher.forward(request, response);

		}else {
		session.invalidate();
		response.sendRedirect("TOP");
		}

	}

}
