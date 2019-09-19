package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductService {
	public Product search(String id);
	public List<Product> searchAll();
	public void add(Product member);
	public void update(Product member);
	public void remove(String id);
}
