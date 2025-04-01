package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection conn;

	public void getDBConnection(String url, String uname, String pwd) throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, uname, pwd);
		} catch (Exception e) {

			System.out.println("Connection not established");
		}

	}

	public void closeDBconnection() {
		try {
			conn.close();
		} catch (Exception e) {

			System.out.println("Connection not closed");
		}

	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result = null;
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeQuery(query);
		} catch (Exception e) {

			System.out.println("Connection not closed");
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result = 0;
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {

			System.out.println("Connection not closed");
		}
		return result;
	}

}
