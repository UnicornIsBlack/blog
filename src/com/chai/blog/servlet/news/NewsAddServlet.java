package com.chai.blog.servlet.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chai.blog.pojo.News;
import com.chai.blog.pojo.Path;
import com.chai.blog.service.FileService;
import com.chai.blog.service.NewsService;


/**
 * Servlet implementation class NewsAddServlet
 */

public class NewsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		HttpSession ses = request.getSession();		
		String title = (String)request.getParameter("title");		
		String content = (String)request.getParameter("content");		
		
		NewsService nService = new NewsService();
		FileService fService = new FileService();
		
		String type = "News";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		Path path = fService.getFilePath(type, realPath);
		
		News news = new News();		
		news.setPath(path.getFilePath().replace("\\", "\\\\"));
		news.setTitle(title);
		news.setTime(path.getTime());
		boolean newsFlag = nService.addNews(news);
		
		boolean fileFlag = fService.addFile(path, content);
		
		if(newsFlag == true && fileFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/News/add_success.jsp");
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
