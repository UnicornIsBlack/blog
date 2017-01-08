package com.chai.blog.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chai.blog.pojo.Admin;
import com.chai.blog.service.AdminService;


public class AdminEditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		AdminService adminService = new AdminService();
		
		boolean flag = adminService.updateAdmin(admin);
		
		if(flag)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/Admin/edit_success.jsp");
			requestDispatcher.forward(request, response);
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
