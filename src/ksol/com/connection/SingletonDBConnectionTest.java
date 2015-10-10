package ksol.com.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SingletonDBConnectionTest {
	
	private SingletonDBConnection dbSingletonConnection = SingletonDBConnection.getInstance();
	
	private void countAllRecord() {

		try {
			Connection connection = dbSingletonConnection.getConnection();

			Statement statement = (Statement) connection.createStatement();

			ResultSet rs = null;
			int count = 0;

			if (statement != null) {
				rs = statement.executeQuery("SELECT COUNT(*) FROM account");
				if (rs.next()) {

					System.out.println("Number of record: " + rs.getInt(1));
				}
				statement.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonDBConnectionTest test = new SingletonDBConnectionTest();
		test.countAllRecord();
	}

}
