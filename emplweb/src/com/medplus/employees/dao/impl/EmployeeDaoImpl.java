package com.medplus.employees.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.EmployeeDao;
import com.medplus.employees.util.DBQueries;
import com.medplus.employees.util.DateParsing;
import com.mysql.jdbc.Driver;


public class EmployeeDaoImpl implements EmployeeDao {

	Connection conn = null;
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public int addEmployee(Employee employee) {
		int rows = 0;
		openDBConnection();
		try {
			pst = conn.prepareStatement(DBQueries.addempl);
			pst.setInt(1, employee.getEmpcode());
			pst.setString(2, employee.getEmpname());
			pst.setString(3, employee.getJob());
			pst.setDouble(4, employee.getSalary());
			pst.setDate(5, DateParsing.connvertToSqlDate(employee.getDateOfBirth()));
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;

	}

	@Override
	public void openDBConnection() {
		String url = "jdbc:mysql://localhost:3306/medplus";
		String user = "root";
		String pass = "root";

		try {

			DriverManager.registerDriver(new Driver());

			conn = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void close() {

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int updateEmployee(Employee employee) {
		int row = 0;
		openDBConnection();
		try {
			pst = conn.prepareStatement(DBQueries.updateempl);
			pst.setString(2, employee.getJob());
			pst.setDouble(3, employee.getSalary());
			pst.setDate(4, DateParsing.connvertToSqlDate(employee.getDateOfBirth()));
			pst.setInt(5, employee.getEmpcode());
			pst.setString(1, employee.getEmpname());
			row = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return row;
	}

	@Override
	public int deleteEmployee(int empcode) {
		int row = 0;
		openDBConnection();
		try {
			pst = conn.prepareStatement(DBQueries.deleteempl);
			pst.setInt(1, empcode);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return row;

	}

	@Override
	public Employee getEmployee(int empcode) {
		openDBConnection();
		Employee emp = null;
		try {
			pst = conn.prepareStatement(DBQueries.getempdetails);
			pst.setInt(1, empcode);
			ResultSet rs = pst.executeQuery();
			rs.next();
			emp = new Employee();
			emp.setEmpcode(rs.getInt(1));
			emp.setEmpname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			emp.setDateOfBirth(rs.getDate(5));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return emp;

	}

	@Override
	public List<Employee> getEmplist() {
		openDBConnection();
		List<Employee> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(DBQueries.getlist);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			close();
		}
		return list;
	}
}
