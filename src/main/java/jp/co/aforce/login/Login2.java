package jp.co.aforce.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Dao.ProductDao;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Login
 */
@WebServlet("/jp.co.aforce/login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    Page.header(out);

	    HttpSession session = request.getSession(); // セッションオブジェクトを取得
	    

	    String admin_id = request.getParameter("admin_id");
	    String password = request.getParameter("password");
	    try {
	        ProductDao login = new ProductDao();
	        boolean loggedIn = login.login2(admin_id, password);


	        if (loggedIn) {
	            session.setAttribute("admin_id", admin_id); // セッションにデータを保存

	            RequestDispatcher rd = request.getRequestDispatcher("/views/itemInsert.jsp");
	            rd.forward(request, response);

	        } else {
	            // ログイン失敗時の処理
	            RequestDispatcher rd = request.getRequestDispatcher("/views/admin.jsp");
	            request.setAttribute("errorMessage", "ログインに失敗しました。");
	            rd.forward(request, response);
	        }
	    } catch (Exception e) {

	    }
	}
}
