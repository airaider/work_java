package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.Product;

public interface ProductDao {
	public List<Product> selectAll(PageBean bean);
	public Product select(String id);
	public void insert(Product product);
	public void update(Product product);
	public void delete(String id);
}
