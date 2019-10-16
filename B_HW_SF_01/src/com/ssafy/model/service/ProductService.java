package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

public interface ProductService {
	public List<Product> selectAll();
	public Product select(String id);
	public void insert(Product product);
	public void update(Product product);
	public void delete(String id);
	public ProductRepo getRepo();
}
