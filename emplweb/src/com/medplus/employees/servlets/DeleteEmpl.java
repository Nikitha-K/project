package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employees.service.AdminService;
import com.medplus.employees.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class DeleteEmpl
 */
@WebServlet("/DeleteEmpl")
public class DeleteEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int empcode =Integer.parseInt(request.getParameter("code"));
		AdminService service = new AdminServiceImpl();
		int rows = service.deleteEmployee(empcode);
		if(rows>0) {
			out.println("deleted");
		}else out.println("not deleted");
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
