package com.chai.blog.servlet.it;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chai.blog.pojo.IT;
import com.chai.blog.pojo.Path;
import com.chai.blog.service.FileService;
import com.chai.blog.service.ITService;


/**
 * Servlet implementation class ITAddServlet
 */

public class ITEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String ID = (String)request.getParameter("it_id");
		
		int id = Integer.parseInt(ID);
		
		FileService fService = new FileService();
		Path path = new Path();
		
		String type = "IT";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		path = fService.getFilePath(type, realPath);
		
		
		IT it = new IT();
		it.setId(id);
		it.setPath(path.getFilePath().replace("\\", "\\\\"));
		it.setTime(path.getTime());
		it.setTitle(title);				
		ITService nService = new ITService();
		
		boolean itFlag = nService.updateIT(it);
		boolean fFlag = fService.addFile(path, content);
		if(itFlag == true && fFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/IT/edit_success.jsp");
			requestDispatcher.forward(request,response);
		}
		
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
