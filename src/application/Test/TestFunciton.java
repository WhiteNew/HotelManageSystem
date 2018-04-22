/**
 * 
 */
package application.Test;

import java.util.ArrayList;
import java.util.List;

import application.bean.Customer;
import application.model.FunctionImp;

/**
 * @author Baixin
 *
 */
public class TestFunciton {

	
	public static void  print(Object ob) {
		 System.out.println(ob);
		 
		 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Customer> custlist = new ArrayList<Customer>();
		 custlist=(new FunctionImp()).QueryAllcustomers(); 
		 for(Customer c: custlist) {
			 print(c);
			 print(c.getUserid()
					 +"\t"+c.getUsername());
			 }
	}

}
