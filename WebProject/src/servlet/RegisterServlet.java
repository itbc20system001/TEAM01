package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.HappyLife;
import javabeans.Register;
import model.HappyGive;
import model.RegisterLogic;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//"touroku.jsp"へフォワード処理
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("touroku.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//ユーザー登録情報をRegisterにセット
		Register reg = new Register();
		reg.setL_name(request.getParameter("l_name"));
		reg.setF_name(request.getParameter("f_name"));
		reg.setL_name_kana(request.getParameter("l_name_kana"));
		reg.setF_name_kana(request.getParameter("f_name_kana"));
		reg.setPrefecture(request.getParameter("prefecture"));
		reg.setCity(request.getParameter("city"));
		reg.setO_address(request.getParameter("o_address"));
		reg.setTel(request.getParameter("tel"));
		reg.setEmail(request.getParameter("email"));
		//reg.setBirthday(request.getParameter("birthday"));
		reg.setPassword(request.getParameter("password"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		reg.setBirthday(year+"-"+month+"-"+day);

		//めんどくさくなったので先にKPのランダムを計算してからデータベースにぶち込む
		HappyLife happyLife = new HappyLife();
		HappyGive happyGive = new HappyGive();
		happyLife.setHappypoint(happyGive.pointExcute(reg));
		request.setAttribute("KP", happyLife);
		//ログイン処理
		RegisterLogic bo = new RegisterLogic();
		boolean isEmailResult = bo.emailExecute(reg);//既に同じemailがないかチェック
		boolean dbResult=false;
		boolean inputResult=false;
		if(!isEmailResult) {
			//boolean dbResult = bo.dbExcute(reg);//DB上の成否
			dbResult= bo.kpExcute(happyLife,reg);//↑の処理を発展のため分ける
			inputResult= bo.inputExcute(reg);//jspでのユーザー側の入力の不備

			//ログイン処理の成否によって条件を分岐
			if (dbResult && inputResult) { //成功時
				request.setCharacterEncoding("UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tourokucomplete.jsp");
				dispatcher.forward(request, response);
			} else if(!dbResult && inputResult){ //失敗時
				happyLife.setMessage("生年月日の入力が間違っています");
				request.setCharacterEncoding("UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/touroku_error.jsp");
				dispatcher.forward(request, response);
			}else{
				happyLife.setMessage("入力箇所に洩れがあります");
				request.setCharacterEncoding("UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/touroku_error.jsp");
				dispatcher.forward(request, response);
			}

		}else {
			happyLife.setMessage("同じメールアドレスが登録されているか、何も入力されていません");
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/touroku_error.jsp");
			dispatcher.forward(request, response);
		}




	}
}
