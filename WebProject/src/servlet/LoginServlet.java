package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
/*		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		User user = new User(email,pass);
		
		LoginLogic loginlogic = new LoginServlet();
		boolean isLogin = loginLogic.execute(user);
		
		if(isLogin) {
			HttpSession session = request.getSession();
		}*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/kakushouhin.jsp");
		dispatcher.forward(request,response);
	}
}
