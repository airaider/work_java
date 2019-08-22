package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.ssafy.model.dao.EmployeeDao;
import com.ssafy.model.dao.EmployeeDaoImp;
import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public class EmployeeServiceImp implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImp();
	public Employee findEmployee(String empno) throws CanNotFindException {
		try {
			Employee emp = dao.findEmployee(empno);
			if(emp == null) {
				throw new CanNotFindException("사원 번호에 해당하는 사원을 찾을 수 없습니다.");
			}else {
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CanNotFindException("사원 정보 조회 중 오류 발생");
		}
	}
	public List<Employee> searchAll() {
		try {
			return dao.searchAll();
		} catch (SQLException e) {
			 throw new RuntimeException("사원 리스트 조회 하는 중 오류 발생");
		}
	}
	public void add(Employee emp) throws DuplicateException {
		try {
			Employee find = dao.findEmployee(emp.getEmpno());
			if(find!=null) {
				throw new DuplicateException("이미 등록된 사원번호입니다.");
			}else {
				dao.add(emp);
			}
		} catch (SQLException e) {
			throw new DuplicateException("사원 정보를 저장하는 중 오류 발생");
		}
	}
	public void update(Employee emp) throws CanNotFindException {
		try {
			Employee find = dao.findEmployee(emp.getEmpno());
			if(find==null) {
				throw new CanNotFindException("수정할 사원 정보를 찾지 못했습니다.");
			}else {
				dao.update(emp);
			}
		} catch (SQLException e) {
			throw new CanNotFindException("사원 정보를 수정하는 중 오류 발생");
		}
	}
	public void remove(String empno) throws CanNotFindException {
		try {
			Employee find = dao.findEmployee(empno);
			if(find==null) {
				throw new CanNotFindException("삭제할 사원 정보를 찾지 못했습니다.");
			}else {
				dao.remove(empno);
			}
		} catch (SQLException e) {
			throw new CanNotFindException("사원 정보를 삭제하는 중 오류 발생");
		}
	}
	public void close() {
		System.exit(0);
	}
}







