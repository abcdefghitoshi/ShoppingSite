package jp.co.aforce.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Dao.ProductDao;
import jp.co.aforce.beans.Item;

@WebServlet("/jp.co.aforce/itemsearch")
public class ItemSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // セッションを取得
        HttpSession session = request.getSession();

        // 検索キーワードの取得
        String keyword = request.getParameter("keyword");

        // 商品の検索処理
        try {
            ProductDao productDao = new ProductDao();
            List<Item> itemList;

            itemList = productDao.search(keyword);

            // 検索結果をセッションに保存
            session.setAttribute("itemList", itemList);

            // 商品一覧ページにフォワード
            RequestDispatcher rd = request.getRequestDispatcher("../views/item.jsp");
            request.setAttribute("itemList", itemList);
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    

       
    }
}