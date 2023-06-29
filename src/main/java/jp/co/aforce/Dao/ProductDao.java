package jp.co.aforce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.Product;

public class ProductDao extends DAO {

//会員登録処理
	public void insertMember(Product product) throws Exception {
		Connection con = getConnection();
		   String insertQuery = "INSERT INTO member("
		            + "member_id, password) "
		            + "VALUES (?, ?)";
		        PreparedStatement insertStatement = con.prepareStatement(insertQuery);
		        insertStatement.setString(1, product.getMember_id());
		        insertStatement.setString(2, product.getPassword());
		     

		        insertStatement.executeUpdate();
		        con.commit();
		        insertStatement.close();
	}
	
//会員登録検索機能
	
	public int countMember(Product product) throws SQLException {
        int count = 0;

        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT COUNT(*) AS count FROM member WHERE "
            		+"member_id=? "
            		+ "AND password=? ";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            
		    selectStatement.setString(1, product.getMember_id());
		    selectStatement.setString(2, product.getPassword());
	

		    ResultSet rs = selectStatement.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}return count;
    }
	

//ログイン判定処理
	 public boolean login(String member_id, String password) throws Exception {
	        boolean loggedIn = false;

	        try (Connection con = getConnection()) {
	            String selectQuery = "SELECT * FROM member WHERE member_id=? AND password=?";
	            PreparedStatement ps = con.prepareStatement(selectQuery);

	            ps.setString(1, member_id);
	            ps.setString(2, password);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                loggedIn = true;
	            }

	            rs.close();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return loggedIn;
	    }
	 
	//管理者ログイン判定処理
		 public boolean login2(String admin_id, String password) throws Exception {
		        boolean loggedIn = false;

		        try (Connection con = getConnection()) {
		            String selectQuery = "SELECT * FROM admin WHERE admin_id=? AND password=?";
		            PreparedStatement ps = con.prepareStatement(selectQuery);

		            ps.setString(1, admin_id);
		            ps.setString(2, password);

		            ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		                loggedIn = true;
		            }

		            rs.close();
		            ps.close();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return loggedIn;
		    }

	 public List<Item> search(String keyword) throws Exception {
		    List<Item> list = new ArrayList<>();
		    
		    Connection con = getConnection();
		    PreparedStatement st = null;
		    ResultSet rs = null;
		    
		    try {
		        st = con.prepareStatement("select * from item where item_name like ?");
		        st.setString(1, "%" + keyword + "%");
		        rs = st.executeQuery();
		        
		        while (rs.next()) {
		            Item i = new Item();
		            i.setItem_no(rs.getInt("item_no"));
		            i.setItem_name(rs.getString("item_name"));
		            i.setItem_price(rs.getInt("item_price"));
		            list.add(i);
		        }
		    } finally {
		        if (rs != null) {
		            rs.close();
		        }
		        if (st != null) {
		            st.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    }
		    
		    return list;
		}
	 
//データベースの商品一覧機能
	 public List<Item> getAllItems()throws Exception {
	        List<Item> itemList = new ArrayList<>();

	        try (Connection connection = getConnection()) {
	            String selectQuery = "SELECT * FROM item";
	            PreparedStatement statement = connection.prepareStatement(selectQuery);
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	            	Item i= new Item();
	            	i.setItem_no(rs.getInt("item_no"));
	            	i.setItem_name(rs.getString("item_name"));
	            	i.setItem_price(rs.getInt("item_price"));
	                itemList.add(i);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return itemList;
	    }

	 
//商品をデータベースへ追加処理
	 public int insert(Item item)throws Exception{
		 Connection con=getConnection();
		 
		 PreparedStatement st=con.prepareStatement(
				 "insert into item values(null, ?, ?)");
		 st.setString(1,item.getItem_name());
		 st.setInt(2, item.getItem_price());
		 int line=st.executeUpdate();
		 
		 st.close();
		 con.close();
		 return line;
	 }
}

