package Assignment9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getInstance() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedetails",
				"root", "Yogi@6591");
		return con;
	}
}
