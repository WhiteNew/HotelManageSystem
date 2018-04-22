package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.bean.Customer;

/**
 * @author Baixin  
 *
 */
public class MysqlConnect {
	
	 // 加载数据库驱动  com.mysql.jdbc.Driver
    private static String dbdriver = "com.mysql.jdbc.Driver";
    // 获取mysql连接地址
    private static String dburl = "jdbc:mysql://localhost:3306/HotelManageSystem?&useSSL=false";
    // 数据名称
    private static String username = "root";
    // 数据库密码
    private static String userpassword = "123456";
    
    private static String  myDatbaseName="HotelManageSystem";
    // 获取一个数据的连接
    public static Connection conn = null;
    // 获取连接的一个状态

    
/**
 * 获取数据库连接
 * 
 * @param ob
 * @return
 */
 
public static Connection getConn() {
    Connection conn = null;
    try {
        Class.forName(dbdriver);            
      
        conn = DriverManager.getConnection(dburl, username, userpassword);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
/**
 * 关闭数据库连接
 * 
 * @param rs
 * @param ps
 * @param conn
 */
public static void closeAll(ResultSet rs, PreparedStatement ps,
        Connection conn) {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (conn == null)
        return;
    try {
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}

