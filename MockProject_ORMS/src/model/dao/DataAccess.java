/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DataAccess.java
 *
 * Version 1.0
 *
 * Date: 03-05-2017
 *
 * Copyright
 *
 * Modification Logs: 
 * DATE 		AUTHOR 		DESCRIPTION
 * -----------------------------------------------------------------------
 * 03-05-2017 	DuyenTB 	Create
 */
public class DataAccess {
	Connection conn = null;

	/**
	 * Method connect Database
	 * 
	 * @return conn
	 * @throws Exception 
	 */
	public Connection getConnect() throws Exception {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ORMS;user=sa;password=12345678;");
		} catch (ClassNotFoundException e) {
			throw new Exception("Error occur: "+ e.getMessage());
		} catch (SQLException e) {
			throw new Exception("Error occur: "+ e.getMessage());
		}
		return conn;
	}
}
