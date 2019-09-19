package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.product.dto.Product;
import com.ssafy.util.DBUtil;

public class ProductDAOImp implements ProductDAO {
	public Product search(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from product where no = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Product(rs.getString("no")
						        , rs.getString("name")
						        , rs.getString("price")
						        , rs.getString("explain"));
			}
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
		return null;
	}

	public List<Product> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from product  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> members = new LinkedList<Product>();
			while(rs.next()) {
				members.add(new Product(rs.getString("no")
				        , rs.getString("name")
				        , rs.getString("price")
				        , rs.getString("explain")));
			}
			return members;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}
	public void add(Product member) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into product "
					   + " values(?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getNo());		
			stmt.setString(idx++, member.getName());		
			stmt.setString(idx++, member.getPrice());		
			stmt.setString(idx++, member.getExplain());		
			System.out.println(stmt);
			stmt.executeUpdate();
			System.out.println("??");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
			System.out.println("!!");
		}
	}
	public void update(Product member) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update product set no=?, name=?, price=?, explain=? "
						+" where no=? " ;
			
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getNo());		
			stmt.setString(idx++, member.getName());		
			stmt.setString(idx++, member.getPrice());		
			stmt.setString(idx++, member.getExplain());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void remove(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from product where id=? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}







