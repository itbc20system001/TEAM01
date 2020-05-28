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
import javabeans.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//		HttpSession session = request.getSession();
		//		HappyLife happyLife = new HappyLife();
		//		session.setAttribute("happy", happyLife);


		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =request.getRequestDispatcher("kakushouhin.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("購入");
		System.out.println(name);
		String path="";
		HttpSession session = request.getSession();
		HappyLife happyLife =(HappyLife)session.getAttribute("happy");
		ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

		ArrayList<Product> p_Buy_List = happyLife.getP_Buy_List();
		if(name.equals(productList.get(0).getP_name()+"を購入")) {
			path="shouhin1.jsp";
			p_Buy_List.add(productList.get(0));
			happyLife.setP_Buy_List(p_Buy_List);

			System.out.println(p_Buy_List.get(0).getP_name());
		}else if(name.equals(productList.get(1).getP_name()+"を購入")) {
			path="shouhin2.jsp";
			p_Buy_List.add(productList.get(1));
			happyLife.setP_Buy_List(p_Buy_List);
		}else if(name.equals(productList.get(2).getP_name()+"を購入")) {
			path="shouhin3.jsp";
			p_Buy_List.add(productList.get(2));
			happyLife.setP_Buy_List(p_Buy_List);
		}else if(name.equals(productList.get(3).getP_name()+"を購入")) {
			path="shouhin4.jsp";
			p_Buy_List.add(productList.get(3));
			happyLife.setP_Buy_List(p_Buy_List);
		}
		//RequestDispatcher dispatcher =request.getRequestDispatcher(path);
		//dispatcher.forward(request, response);
		response.sendRedirect(path);
	}

}
