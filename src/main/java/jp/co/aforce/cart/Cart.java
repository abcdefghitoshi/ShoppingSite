package jp.co.aforce.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartItem;

@WebServlet("/jp.co.aforce/cart")
public class Cart extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        int itemno = Integer.parseInt(request.getParameter("item_no"));
        String itemName = request.getParameter("item_name");
        int itemPrice = Integer.parseInt(request.getParameter("item_price"));
        int count = Integer.parseInt(request.getParameter("count"));

        // カートの取得または新規作成
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(900); // セッション時間制限

        @SuppressWarnings( "unchecked" )
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // カートにアイテムを追加
        CartItem cartItem = new CartItem(itemno, itemName, itemPrice, count);
        if (cart.contains(cartItem)) {
            // 同じ商品が既にカート内に存在する場合は、個数を更新する
            int existingItemIndex = cart.indexOf(cartItem);
            CartItem existingItem = cart.get(existingItemIndex);
            existingItem.setCount(existingItem.getCount() + count);
        } else {
        
        cart.add(cartItem);
        }

        // カートに追加完了のメッセージをリクエスト属性に設定
        RequestDispatcher rd = request.getRequestDispatcher("/views/item.jsp");
        request.setAttribute("message", itemName+"が"+count+"個カートに商品を追加しました。");
        rd.forward(request, response);

    }
}