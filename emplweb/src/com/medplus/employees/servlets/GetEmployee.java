package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.service.AdminService;
import com.medplus.employees.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp= null;
	AdminService service = new AdminServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empcode =Integer.parseInt(request.getParameter("code"));
		emp= service.getEmployee(empcode);
		RequestDispatcher rd =request.getRequestDispatcher("GetEmployee.jsp");
		request.setAttribute("emp",emp);
	rd.forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
