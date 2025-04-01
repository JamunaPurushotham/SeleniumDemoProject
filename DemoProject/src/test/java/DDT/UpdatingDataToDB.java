package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdatingDataToDB {
	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza", "root", "admin");

		Statement stmt = conn.createStatement();

		int result = stmt.executeUpdate("update Ninza_CRM_Details set uname='admin' where Browser='safari'");

		System.out.println(result);
		if (result != 0) {
			System.out.println("Data stored Successfully");

		} else {
			System.out.println("Failed");
		}
		conn.close();

	}

}
