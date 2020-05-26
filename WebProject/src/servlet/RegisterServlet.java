package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =request.getRequestDispatcher("touroku.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String l_name = request.getParameter("l_name");
		String f_name = request.getParameter("f_name");
		String l_name_kana = request.getParameter("l_name_kana");
		String f_name_kana = request.getParameter("f_name_kana");
		String prefecture = request.getParameter("prefecture");
		String city = request.getParameter("city");
		String o_address = request.getParameter("o_address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");

		//リクエストパラメータをチェック
		if(l_name == null || l_name.length()==0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(f_name == null ||  f_name.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(f_name == null ||  f_name.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(l_name_kana == null ||  l_name_kana.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(f_name_kana == null ||  f_name.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(prefecture == null ||  prefecture.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(city == null ||  city.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(o_address == null ||  o_address.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(tel == null ||  tel.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(email== null ||  email.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if(birthday == null ||  birthday.length() == 0) {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);
		}else if( password == null ||  password.length() == 0){
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("touroku_error.jsp");
			dispatcher.forward(request, response);

		}else {
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =request.getRequestDispatcher("tourokucomplete.jsp");
			dispatcher.forward(request, response);
		}

	}
}


