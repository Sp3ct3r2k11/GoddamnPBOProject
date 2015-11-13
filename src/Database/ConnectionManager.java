
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    private static final String server = "jdbc:mysql://localhost/tubes_pbo";
	private static final String username = "root";
	private static final String password = "";
	private static Connection connection;
	
	public static Connection getConnection() {
		
		if(connection == null) {
			connection = logOn();
		}
		return connection;
	}
	
	private static Connection logOn() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection Success");
			return DriverManager.getConnection(server, username, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
			System.out.println("Connection Failed" + e.toString());
			
		} catch (ClassNotFoundException ex) {
			
			ex.printStackTrace(System.err);
			System.out.println("JDBC.ODBC Driver Not Found");
			
		}
		
		return null;
	}
}
