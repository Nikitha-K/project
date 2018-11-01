package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		int empcode =Integer.parseInt(request.getParameter("empcode"));
		String empname = request.getParameter("empname");
		String job = request.getParameter("job");
		Double sal =Double.parseDouble(request.getParameter("salary"));
		String dob = request.getParameter("dateofbirth");
		Employee emp = new Employee();
		emp.setEmpcode(empcode);
		emp.setEmpname(empname);
		emp.setJob(job);
		emp.setSalary(sal);
		emp.setDateOfBirth(DateParsing.convertToUtilDate(dob));
		AdminService service = new AdminServiceImpl();
		int rows =service.addEmployee(emp);
		if(rows>0) {
			out.println("inserted");
			
		}else out.println("not inserted");
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
