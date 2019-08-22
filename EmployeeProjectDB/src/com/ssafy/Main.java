package com.ssafy;

import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;
import com.ssafy.model.service.EmployeeService;
import com.ssafy.model.service.EmployeeServiceImp;
import com.ssafy.view.EmployeeUI;

public class Main {
	public static void main(String[] args) {
		EmployeeService dao = new EmployeeServiceImp();
		EmployeeUI  mainView = new EmployeeUI();
		mainView.setModel(dao);
	}
}