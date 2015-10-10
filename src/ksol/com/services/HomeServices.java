package ksol.com.services;

import java.util.List;

import ksol.com.beans.Product;
import ksol.com.connection.SingletonDBConnection;

public interface HomeServices {
	
	public List<Product> getLatestProducts(SingletonDBConnection dbSingletonConnection);
}
