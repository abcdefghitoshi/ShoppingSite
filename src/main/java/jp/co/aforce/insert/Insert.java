package jp.co.aforce.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.Dao.ProductDao;
import jp.co.aforce.beans.Product;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/jp.co.aforce/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		
			//formから会員情報登録
			String member_id = request.getParameter("member_id");
			String password = request.getParameter("password");

			
			//Productにセット
			Product p = new Product();
			p.setMember_id(member_id);
			p.setPassword(password);
	
			
			try {
				
				ProductDao pd=new ProductDao();
	            int count = pd.countMember(p);
	            
	            if (count > 0) {
	                out.println("すでに登録されています。");
	                out.println("<button onclick=\"location.href='http://localhost:8080/ShoppingSite/views/top.html'\">TOP</button>");
	                
	                
	            } else {
	                // 登録機能を持つDAOをインスタンス化し、会員を登録する
	            	out.println("登録が完了しました");
	            	out.println("<button onclick=\"location.href='http://localhost:8080/ShoppingSite/views/top.html'\">TOP</button>");
	                ProductDao  insertMember = new ProductDao();
	                insertMember.insertMember(p);
	                
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

			} finally {
	            Page.footer(out);
	            
	        }
	    }

}
