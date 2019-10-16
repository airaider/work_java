package com.ssafy.model.repository;

import java.util.List;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.Product;

public interface ProductRepo {
	public List<Product> selectAll(PageBean bean);
	public Product select(String id);
	public void insert(Product product);
	public void update(Product product);
	public void delete(String id);
}
