package com.ssafy.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductDAO {
	public Product search( String id) throws SQLException;
	public List<Product> searchAll( ) throws SQLException;
	public void add(Product member)	 throws SQLException;
	public void update(Product member)throws SQLException;
	public void remove(String id)    throws SQLException;
	
}
