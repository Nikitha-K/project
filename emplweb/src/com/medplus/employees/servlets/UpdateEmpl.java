package com.medplus.employees.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.service.AdminService;
import com.medplus.employees.service.impl.AdminServiceImpl;
import com.medplus.employees.util.DateParsing;

/**
 * Servlet implementation class UpdateEmpl
 */
@WebServlet("/UpdateEmpl")
public class UpdateEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = new AdminServiceImpl();
	Employee emp= null;
	
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		emp=service.getEmployee(code);
		System.out.println(emp.getEmpname()); 
		RequestDispatcher rd =request.getRequestDispatcher("UpdateEmpl.jsp");
		request.setAttribute("employee",emp);
	rd.forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empcode=Integer.parseInt(request.getParameter("empcode"));
		String empname =request.getParameter("empname");
		String job = request.getParameter("job");
		double sal=Double.parseDouble(request.getParameter("salary"));
		String dob = request.getParameter("dateofbirth");
		emp=new Employee();
		emp.setEmpcode(empcode);
		emp.setEmpname(empname);
		emp.setJob(job);
		emp.setSalary(sal);
		emp.setDateOfBirth(DateParsing.convertToUtilDate(dob));
		int rows =service.updateEmployee(emp);
		RequestDispatcher rd = request.getRequestDispatcher("ViewEmpls");
		rd.forward(request,response);
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
