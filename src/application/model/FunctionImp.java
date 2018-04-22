/**
 * 
 */
package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.bean.Customer;
import application.model.MysqlConnect;
/**
 * @author Baixin
 *
 */
public class FunctionImp implements FunctionApi {

	/* 
	 * @see application.model.FunctionApi#QueryAllcustomers()
	 */
	@Override
	public List<Customer> QueryAllcustomers() {
		// 
		    Connection conn = MysqlConnect.getConn();
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    List<Customer> custlist = new ArrayList<Customer>();
		    String sql="select * from Customer";
		    try {
		        ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();
		        ResultSetMetaData md = rs.getMetaData();
		        int columnCount = md.getColumnCount();
		        while (rs.next()) {
		           Customer cust=new Customer();
		         cust.setUserid(rs.getString(1));
		         cust.setUsername(rs.getString(2));
		         cust.setGender(rs.getString(3));
		         cust.setCity(rs.getString(4));
		         cust.setAdress(rs.getString(5));
		         cust.setPhone(rs.getString(6));
		         cust.setBirthday(rs.getString(7));
		        
		         custlist.add(cust);
		            }
		          
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		    	MysqlConnect.closeAll(rs, ps, conn);
		    }
		    return custlist;
		}
	}


