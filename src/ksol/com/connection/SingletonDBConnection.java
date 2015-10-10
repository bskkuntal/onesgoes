package ksol.com.connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SingletonDBConnection {
	
	private static SingletonDBConnection	instance	= null;
	private Connection						connection	= null;
	
	private SingletonDBConnection() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eCommerce", "root", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the instance
	 */
	public static SingletonDBConnection getInstance() {
		try {
			if (instance == null || instance.getConnection().isClosed()) {
				instance = new SingletonDBConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instance;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
