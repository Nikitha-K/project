package com.medplus.employees.service;

import java.util.List;

import com.medplus.employees.beans.Employee;

public interface AdminService {
	int addEmployee(Employee employee);
	List<Employee> getEmplist();
	int deleteEmployee(int empcode);
	Employee getEmployee(int empcode);
	int updateEmployee(Employee employee);
	

}
