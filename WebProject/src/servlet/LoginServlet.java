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
import javabeans.Login;
import javabeans.Payment;
import javabeans.Product;
import model.LoginLogic;
import model.ProductListLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//"login.jsp"へフォワード処理
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//入力されたものを格納
		Login login = new Login();
		login.setEmail(request.getParameter("email"));
		login.setPass(request.getParameter("pass"));
		LoginLogic loginLogic = new LoginLogic();

		//ログイン正否
		String path="";
		boolean isLogin =loginLogic.execute(login);

		if(login.getEmail().equals("")||login.getPass().equals("")) {
			isLogin=false;
		}

		if(isLogin) {
			path= "Product";
			//セッションスコープに3つを宣言
			HttpSession session = request.getSession();
			Payment payment = new Payment();
			session.setAttribute("payment", payment);
			HappyLife happyLife = new HappyLife();
			happyLife =loginLogic.sessionExecute(login, happyLife);
			session.setAttribute("happy", happyLife);
			ArrayList<Product> productList = new ArrayList<Product>();
			ProductListLogic productListLogic = new ProductListLogic();
			productList = productListLogic.execute(productList);
			session.setAttribute("product", productList);
			response.sendRedirect(path);
		}else {
			path= "/WEB-INF/jsp/loginerror.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request,response);
		}




	}
}
