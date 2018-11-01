package com.medplus.employees.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ViewEmpls
 */
@WebServlet("/ViewEmpls")
public class ViewEmpls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str =request.getParameter("username");
		AdminService service= new AdminServiceImpl();
		List<Employee> emplist =service.getEmplist();
		System.out.println(emplist.size());
		RequestDispatcher rd= request.getRequestDispatcher("ViewEmpls.jsp");
		request.setAttribute("empls",emplist);
		request.setAttribute("username",str);
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
