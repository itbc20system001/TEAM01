package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.HappyLife;
import javabeans.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Login login = new Login();
		login.setEmail(request.getParameter("email"));
		login.setPass(request.getParameter("pass"));
/*		

		User user = new User(email,pass);

		LoginLogic loginlogic = new LoginServlet();
		boolean isLogin = loginLogic.execute(user);

		if(isLogin) {
			HttpSession session = request.getSession();
		}*/
		HttpSession session = request.getSession();
		HappyLife happyLife = new HappyLife();
		session.setAttribute("happy", happyLife);

		//RequestDispatcher dispatcher = request.getRequestDispatcher("Product");
		//dispatcher.forward(request,response);
		response.sendRedirect("/kohukudo/Product");
	}
}
