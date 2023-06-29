package jp.co.aforce.Dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
    protected static DataSource ds;
    
    public Connection getConnection() throws Exception {
        if (ds == null) {
            InitialContext ic=new InitialContext();
            ds=(DataSource)ic.lookup("java:/comp/env/jdbc/furutsuka_shoppingsite");
        }
        return ds.getConnection();
    }
}
