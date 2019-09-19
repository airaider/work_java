package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.dao.ProductDAO;
import com.ssafy.product.dao.ProductDAOImp;
import com.ssafy.product.dto.Product;
import com.ssafy.product.dto.ProductException;

public class ProductServiceImp implements ProductService {
	private ProductDAO dao = new ProductDAOImp();
	@Override
	public Product search(String id) {
		try {
			Product member = dao.search(id);
			if(member == null) {
				throw new ProductException("등록되지 않은 아이디입니다.");
			}else {
			   return member;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException();
		}
	}

	@Override
	public List<Product> searchAll() {
		try {
			return dao.searchAll();
		}catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public void add(Product member) {
		try {
			Product find = dao.search(member.getNo());
			if(find != null) {
				throw new ProductException("이미 등록된 제품입니다.");
			}else {
				dao.add(member);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}

	}

	@Override
	public void update(Product member) {
		try {
			Product find = dao.search(member.getNo());
			if(find == null) {
				throw new ProductException("수정할 제품 정보가 없습니다.");
			}else {
				dao.update(member);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}

	}

	@Override
	public void remove(String id) {
		try {
			Product find = dao.search(id);
			if(find == null) {
				throw new ProductException("삭제할 제품 정보가 없습니다.");
			}else {
				dao.remove(id);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}

	}

}
