package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if((user.equals("admin") && pass.equals("admin")))
        {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			RequestDispatcher rd =request.getRequestDispatcher("Admin.jsp");
			rd.forward(request,response);
			
        }
		else if((user.equals("user1") && pass.equals("user1"))) {
			RequestDispatcher rd =request.getRequestDispatcher("User1.jsp");
			rd.forward(request,response);
			
			
		}else out.println("incorrect details");
        	
        
        	
		
	}

}
