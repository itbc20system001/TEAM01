package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

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


		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			HappyLife happyLife = (HappyLife) session.getAttribute("happy");
			if(happyLife.getHappypoint()<0) {
				response.sendRedirect("-");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kakushouhin.jsp");
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
		String name=request.getParameter("購入");
		String name2 = name.replaceAll("[^0-9]", "");
		//int a= Integer.parseInt(s);
		//System.out.println(name);

		String path="";
		HttpSession session = request.getSession();
		HappyLife happyLife =(HappyLife)session.getAttribute("happy");
		ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("product");

		ArrayList<Product> p_Buy_List = happyLife.getP_Buy_List();

		if(name.equals(productList.get(0).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(0));
		}else if(name.equals(productList.get(1).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(1));
		}else if(name.equals(productList.get(2).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(2));
		}else if(name.equals(productList.get(3).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(3));
		}else if(name.equals(productList.get(4).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(4));
		}else if(name.equals(productList.get(5).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(5));
		}else if(name.equals(productList.get(6).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(6));
		}else if(name.equals(productList.get(7).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(7));
		}else if(name.equals(productList.get(8).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(8));
		}else if(name.equals(productList.get(9).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(9));
		}else if(name.equals(productList.get(10).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(10));
		}else if(name.equals(productList.get(11).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(11));
		}else if(name.equals(productList.get(12).getP_name()+"を購入")) {
			p_Buy_List.add(productList.get(12));
		}


		p_Buy_List = new ArrayList<Product>(new LinkedHashSet<>(p_Buy_List));
		happyLife.setP_Buy_List(p_Buy_List);
		//RequestDispatcher dispatcher =request.getRequestDispatcher("shouhin.jsp");
		//dispatcher.forward(request, response);
		response.sendRedirect("Shouhin");
	}

}
