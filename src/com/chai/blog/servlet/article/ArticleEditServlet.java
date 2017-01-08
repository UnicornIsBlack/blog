package com.chai.blog.servlet.article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chai.blog.pojo.Article;
import com.chai.blog.pojo.Path;
import com.chai.blog.service.FileService;
import com.chai.blog.service.ArticleService;


/**
 * Servlet implementation class ArticleAddServlet
 */

public class ArticleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String ID = (String)request.getParameter("article_id");
		
		int id = Integer.parseInt(ID);
		
		FileService fService = new FileService();
		Path path = new Path();
		
		String type = "Article";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		path = fService.getFilePath(type, realPath);
		
		
		Article article = new Article();
		article.setId(id);
		article.setPath(path.getFilePath().replace("\\", "\\\\"));
		article.setTime(path.getTime());
		article.setTitle(title);				
		ArticleService nService = new ArticleService();
		
		boolean articleFlag = nService.updateArticle(article);
		boolean fFlag = fService.addFile(path, content);
		if(articleFlag == true && fFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/Article/edit_success.jsp");
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
