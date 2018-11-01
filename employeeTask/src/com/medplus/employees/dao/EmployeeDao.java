package com.medplus.employees.dao;


import java.util.List;

import com.medplus.employees.beans.Employee;

public interface EmployeeDao {
	int addEmployee(Employee employee);
	void openDBConnection();
	void close();
	List<Employee> getEmplist();
	int deleteEmployee(int empcode);
	Employee getEmployee(int empcode);
	int updateEmployee(Employee employee);
	
	

}
