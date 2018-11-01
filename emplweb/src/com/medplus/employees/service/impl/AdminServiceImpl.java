package com.medplus.employees.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.EmployeeDao;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;
import com.medplus.employees.service.AdminService;

public class AdminServiceImpl implements AdminService {
	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public int addEmployee(Employee employee) {
		int rows = 0;
		rows = dao.addEmployee(employee);
		return rows;
	}

	@Override
	public List<Employee> getEmplist() {
		List<Employee> list = new ArrayList<>();
		list = dao.getEmplist();
		return list;
	}

	@Override
	public int deleteEmployee(int empcode) {
		int rows = 0;
		rows =dao.deleteEmployee(empcode);

		return rows;
	}

	@Override
	public Employee getEmployee(int empcode) {
		Employee emp = dao.getEmployee(empcode);
		return emp;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int rows = 0;
		rows = dao.updateEmployee(employee);
		return rows;
		// TODO Auto-generated method stub

	}

}
