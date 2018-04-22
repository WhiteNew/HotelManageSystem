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
	
	 // �������ݿ�����  com.mysql.jdbc.Driver
    private static String dbdriver = "com.mysql.jdbc.Driver";
    // ��ȡmysql���ӵ�ַ
    private static String dburl = "jdbc:mysql://localhost:3306/HotelManageSystem?&useSSL=false";
    // ��������
    private static String username = "root";
    // ���ݿ�����
    private static String userpassword = "123456";
    
    private static String  myDatbaseName="HotelManageSystem";
    // ��ȡһ�����ݵ�����
    public static Connection conn = null;
    // ��ȡ���ӵ�һ��״̬

    
/**
 * ��ȡ���ݿ�����
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
 * �ر����ݿ�����
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

