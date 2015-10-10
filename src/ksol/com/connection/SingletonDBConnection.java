package ksol.com.connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import ksol.com.utils.DATABASE_CONSTANT_KEY;

import com.mysql.jdbc.Connection;

public class SingletonDBConnection {
	
	private static SingletonDBConnection	instance	= null;
	private Connection						connection	= null;
	
	private SingletonDBConnection() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(DATABASE_CONSTANT_KEY.DATABASE_HOST + ":" + 
																  DATABASE_CONSTANT_KEY.DATABASE_PORT + "/" + 
																  DATABASE_CONSTANT_KEY.DATABASE_NAME, 
																  DATABASE_CONSTANT_KEY.DATABASE_USERNAME, DATABASE_CONSTANT_KEY.DATABASE_PASSWORD);
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
