package jp.co.aforce.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartItem;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/jp.co.aforce/payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

	        // 入力された名前と住所の取得
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String payment = request.getParameter("payment");

	        // カートのアイテム情報を取得
	        @SuppressWarnings("unchecked")
			List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");


	        // リクエスト属性に必要な情報を設定
	        request.setAttribute("name", name);
	        request.setAttribute("address", address);
	        request.setAttribute("cart", cart);
	        request.setAttribute("payment", payment);

	        RequestDispatcher rd = request.getRequestDispatcher("../views/complete.jsp");
	        rd.forward(request, response);
	        
	        
	    }

	}
