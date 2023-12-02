package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

	private static DbConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/";
	private String bdd="soa";
	private String username = "root";
	private String password = "";

	private DbConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url+bdd, username, password);
			System.out.println("Connection à la base de donnnée '"+bdd+"' est etablie.");
		} catch (ClassNotFoundException ex) {
			System.out.println("JDBC Absent : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DbConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DbConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DbConnection();
		}
		return instance;
	}

	public static void main(String[] args) {
		try {
			DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}