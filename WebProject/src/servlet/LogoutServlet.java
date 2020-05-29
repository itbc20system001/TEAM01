package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			String logout = request.getParameter("logoutyn");
			if (logout.equals("yes")) {

				HttpSession session = request.getSession(true);
				//session.removeAttribute("happy");
				session.invalidate();
				response.sendRedirect("logout_kanryou.jsp");
			} else {
				response.sendRedirect("Product");
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("top.jsp");
		}
	}
}
