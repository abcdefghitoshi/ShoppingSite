package jp.co.aforce.cart;

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
 * Servlet implementation class CartDelete
 */
@WebServlet("/jp.co.aforce/cartdelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		
		
		// 削除するアイテムの商品番号を取得
        int itemNo = Integer.parseInt(request.getParameter("item_no"));

        // カートの取得
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        // カート内のアイテムを削除
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getItem_no()==itemNo) {
                    cart.remove(item);
                    break;
                }
            }
        }

        // カートページへリダイレクト
        RequestDispatcher rd = request.getRequestDispatcher("/views/cart.jsp");
        rd.forward(request, response);

	}

}
