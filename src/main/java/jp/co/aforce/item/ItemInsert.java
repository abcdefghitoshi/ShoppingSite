package jp.co.aforce.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Dao.ProductDao;
import jp.co.aforce.beans.Item;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class ItemInsert
 */
@WebServlet("/jp.co.aforce/iteminsert")
public class ItemInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		Page.header(out);
		
		try {
			String name=request.getParameter("item_name");
			int price=Integer.parseInt(request.getParameter("item_price"));
			
			Item i=new Item();
			i.setItem_name(name);
			i.setItem_price(price);
			
			ProductDao dao=new ProductDao();
			int line = dao.insert(i);
			
			
			if(line>0) {
				out.print("追加の商品に成功しました");
				out.println("<button onclick=\"location.href='http://localhost:8080/ShoppingSite/views/top.html'\">TOP</button>");
			}

				
			}catch(Exception e){
				e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
