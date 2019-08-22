package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public interface EmployeeDao {
	public Employee findEmployee(String empno) throws SQLException;
	void add(Employee emp)	throws SQLException;
	void update(Employee emp) throws SQLException;
	void remove(String empno) throws SQLException;
	public List<Employee> searchAll() throws SQLException;
}
