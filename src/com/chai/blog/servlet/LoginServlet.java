package com.chai.blog.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chai.blog.service.AdminService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getSession().invalidate();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		AdminService aService = new AdminService();
		boolean flag = aService.checkAdmin(username, password);

		if (flag) {
			request.getSession().setAttribute("username", username);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("pages/Admin/login/success.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.getSession().setAttribute("error", "error");
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("pages/Admin/login/failure.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
