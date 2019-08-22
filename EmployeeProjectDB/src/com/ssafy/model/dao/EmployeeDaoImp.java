package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;
import com.ssafy.util.DBUtil;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public Employee findEmployee(String empno) throws SQLException{
		Connection con = null;
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from emp where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(empno));
			rs = stmt.executeQuery();
			List<Employee> emps = new LinkedList<>();
			if(rs.next()) {
				return new Employee(rs.getString("empno"), rs.getString("ename"), rs.getInt("sal"));
			}
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	public void add(Employee emp) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal) "
						+" values(?,?,?) ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setInt(idx++, Integer.parseInt(emp.getEmpno()));
			stmt.setString(idx++, emp.getName());
			stmt.setInt(idx++, emp.getSalary());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void update(Employee emp) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update emp set ename=?, sal=? where empno=? ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, emp.getName());
			stmt.setInt(idx++, emp.getSalary());
			stmt.setInt(idx++, Integer.parseInt(emp.getEmpno()));
			stmt.executeUpdate(); 
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void remove(String empno) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from emp where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(empno));
			stmt.executeUpdate(); 
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public List<Employee> searchAll()  throws SQLException{
		Connection con = null;
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from emp ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Employee> emps = new LinkedList<>();
			while(rs.next()) {
				emps.add(new Employee(rs.getString("empno"), rs.getString("ename"), rs.getInt("sal")));
			}
			return emps;
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}