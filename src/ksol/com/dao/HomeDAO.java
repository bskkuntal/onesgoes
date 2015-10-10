package ksol.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import ksol.com.beans.Product;
import ksol.com.connection.SingletonDBConnection;
import ksol.com.services.HomeServices;

public class HomeDAO implements HomeServices {

	@Override
	public List<Product> getLatestProducts(SingletonDBConnection dbSingletonConnection) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dbSingletonConnection.getConnection();

			Statement statement = (Statement) connection.createStatement();
			String sql = "select product_id, product_name, product_price, product_price_promotion, product_image from ecom_product";
			PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();
			List<Product> list = new ArrayList<Product>();

			if (statement != null) {
				while (rs.next()) {
					Product product = new Product();
					product.setProductID(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setProductPrice(rs.getDouble("product_price"));
					product.setProductPricePromote(rs.getDouble("product_price_promotion"));
					product.setProductImage(rs.getString("product_image"));
					list.add(product);
				}
				statement.close();
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

/*	private SingletonDBConnection dbSingletonConnection = SingletonDBConnection
			.getInstance();
*/


}
