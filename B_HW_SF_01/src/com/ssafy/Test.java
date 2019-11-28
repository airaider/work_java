package com.ssafy;

import java.util.List;

import com.ssafy.model.dao.ProductDao;
import com.ssafy.model.dao.ProductDaoImpl;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.Product;

public class Test {

	public static void main(String[] args) {
		Product product = new Product("100", "ssafy", 5000, "good");
		ProductDao dao = new ProductDaoImpl();
//		try {
//			dao.insert(product);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			dao.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(dao.select("100"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			dao.delete("100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PageBean bean = new PageBean("all", null, 1);
			List<Product> products = dao.selectAll(bean);
			for (Product pro : products) {
				System.out.println(pro);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
