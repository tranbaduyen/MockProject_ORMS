/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HCD-Fresher204
 *
 */
public class DataAccess {
	Connection conn = null;
	
	/**
	 * Connect csdl
	 * @return
	 */
	public Connection getConnect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ORMS;user=sa;password=abc@1234;");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
