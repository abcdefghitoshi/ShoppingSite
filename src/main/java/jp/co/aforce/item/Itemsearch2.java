package jp.co.aforce.item;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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

/**
 * Servlet implementation class Itemsearch2
 */
@WebServlet("/jp.co.aforce/itemsearch2")
public class Itemsearch2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Itemsearch2() {
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
		// リクエストパラメータの取得
		String sortOption = request.getParameter("sort");
		// セッションを取得
        HttpSession session = request.getSession();

		try {// 商品データの取得
			ProductDao productDao = new ProductDao();
			List<Item> itemList = productDao.getAllItems();

			// ソートオプションに応じて商品リストを並び替え
			if ("asc".equals(sortOption)) {
				Collections.sort(itemList, Comparator.comparing(Item::getItem_price));
			} else if ("desc".equals(sortOption)) {
				Collections.sort(itemList, Comparator.comparing(Item::getItem_price).reversed());
			}

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
