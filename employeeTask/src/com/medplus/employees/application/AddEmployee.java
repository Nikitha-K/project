package com.medplus.employees.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.dao.EmployeeDao;
import com.medplus.employees.dao.impl.EmployeeDaoImpl;
import com.medplus.employees.util.DateParsing;

public class AddEmployee {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDaoImpl();

		Scanner sc = new Scanner(System.in);

		boolean b = true;
		while (b) {
			System.out.println("enter a for adding employee");
			System.out.println("enter l for employee list");
			System.out.println("enter e for employee details");
			System.out.println("enter u for update details");
			System.out.println("enter d for delete employee ");

			switch (sc.next().charAt(0)) {
			case 'a':
				Employee emp = new Employee();

				System.out.println("enter the emp code");
				emp.setEmpcode(sc.nextInt());
				System.out.println("enter the emp name");
				emp.setEmpname(sc.next());
				System.out.println("enter job details");
				emp.setJob(sc.next());
				System.out.println("enter the emp salary");
				emp.setSalary(sc.nextDouble());
				System.out.println("enter the emp dob");
				emp.setDateOfBirth(DateParsing.convertToUtilDate(sc.next()));
				int rows = 0;
				rows = dao.addEmployee(emp);
				if (rows > 0) {
					System.out.println("inserted");
				} else
					System.out.println("not inserted");
				break;
			case 'u':
				Employee emp1 = new Employee();
				System.out.println("enter the emp code to update");
				emp1.setEmpcode(sc.nextInt());
				System.out.println("enter the emp name");
				emp1.setEmpname(sc.next());
				System.out.println("enter job details");
				emp1.setJob(sc.next());
				System.out.println("enter the emp salary");
				emp1.setSalary(sc.nextDouble());
				System.out.println("enter the emp dob");
				emp1.setDateOfBirth(DateParsing.convertToUtilDate(sc.next()));
				int r = 0;
				r = dao.updateEmployee(emp1);
				if (r > 0) {
					System.out.println("updated");
				} else
					System.out.println("not updated");
				break;

			case 'l':
				List<Employee> list = dao.getEmplist();
				for (Employee e : list) {
					System.out.println(e);
				}
				break;

			case 'e':
				System.out.println("enter the employee code");
				Employee e = dao.getEmployee(sc.nextInt());
				System.out.println(e);
				break;
			case 'd':
				System.out.println("enter the empcode to delete");
				int row = 0;
				row = dao.deleteEmployee(sc.nextInt());
				if (row > 0) {
					System.out.println("deleted");
				} else
					System.out.println("not deleted");
				break;

			default:
				System.out.println("entered wrong input");
				b = false;
				break;

			}

		}

		sc.close();

	}

}
