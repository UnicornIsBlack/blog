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

public class ITAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String ip = request.getHeader("x-forwarded-for");    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("Proxy-Client-IP");    
	    }    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("WL-Proxy-Client-IP");    
	    }    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getRemoteAddr();    
	    }
	    System.out.println(ip);
		
		HttpSession ses = request.getSession();		
		String title = (String)request.getParameter("title");		
		String content = (String)request.getParameter("content");		
		
		ITService nService = new ITService();
		FileService fService = new FileService();
		
		String type = "IT";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		Path path = fService.getFilePath(type, realPath);
		
		IT it = new IT();		
		it.setPath(path.getFilePath().replace("\\", "\\\\"));
		it.setTitle(title);
		it.setTime(path.getTime());
		boolean itFlag = nService.addIT(it);
		
		boolean fileFlag = fService.addFile(path, content);
		
		if(itFlag == true && fileFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/IT/add_success.jsp");
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
