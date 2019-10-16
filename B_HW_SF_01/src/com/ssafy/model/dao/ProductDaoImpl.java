package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.Product;

public class ProductDaoImpl implements ProductDao {
SqlSession session = MyBatis.getSqlSession();
	
	public List<Product> selectAll(PageBean bean) {
		RowBounds rows = new RowBounds(bean.getStart()-1, bean.getInterval());
		return session.selectList("product.searchAll", bean, rows);
	}

	@Override
	public Product select(String id) {
		return session.selectOne("product.search", id);
	}

	@Override
	public void insert(Product product) {
		session.insert("product.insert", product);
		session.commit();
	}

	@Override
	public void update(Product product) {
		session.update("product.update", product);
		session.commit();
	}

	@Override
	public void delete(String id) {
		session.delete("product.delete", id);
		session.commit();
	}
	}
