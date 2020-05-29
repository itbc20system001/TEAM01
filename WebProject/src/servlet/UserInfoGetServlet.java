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
import javabeans.Register;
import model.RegisterLogic;

/**
 * Servlet implementation class UserInfoGet
 */
@WebServlet("/UserInfoGetServlet")
public class UserInfoGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		HappyLife happylife = (HappyLife) session.getAttribute("happy");
		request.setCharacterEncoding("UTF-8");

		//UsrDAOに処理を移してusrテーブルから会員情報をSELECT→Register.javaにセット
		RegisterLogic rl = new RegisterLogic();
		Register reg = new Register();

		System.out.println(happylife.getUserid());

		reg = rl.userInfoGetExcute(reg, happylife);
		request.setAttribute("register", reg);

		//"kaiinjoho.jsp"へフォワード
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("kaiinjoho.jsp");
		dispatcher.forward(request, response);
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
