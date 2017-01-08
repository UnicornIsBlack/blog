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

public class NewsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String ID = (String)request.getParameter("news_id");
		
		int id = Integer.parseInt(ID);
		
		FileService fService = new FileService();
		Path path = new Path();
		
		String type = "News";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		path = fService.getFilePath(type, realPath);
		
		
		News news = new News();
		news.setId(id);
		news.setPath(path.getFilePath().replace("\\", "\\\\"));
		news.setTime(path.getTime());
		news.setTitle(title);				
		NewsService nService = new NewsService();
		
		boolean nFlag = nService.updateNews(news);
		boolean fFlag = fService.addFile(path, content);
		if(nFlag == true && fFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/News/edit_success.jsp");
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
