package com.wu.web.cases;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {
    private static DataSource ds = null;

    private static ThreadLocal<Connection> store = new ThreadLocal<Connection>();

//	private static Connection conn = null;

    static{
        Properties p = new Properties();
        try {
            p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            ds = BasicDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        if(store.get() == null){
            System.out.println(store);
            System.out.println(ds);
            store.set(ds.getConnection());
        }
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "13655671361");
        return connection;
//        return store.get();
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(){
        if(store.get() != null){
            try {
                store.get().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        store.set(null);
    }
}