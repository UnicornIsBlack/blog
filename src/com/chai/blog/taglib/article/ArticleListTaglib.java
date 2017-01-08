package com.chai.blog.taglib.article;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.Article;
import com.chai.blog.service.FileService;
import com.chai.blog.service.ArticleService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.http.HttpServletRequest;

public class ArticleListTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
			
			ArticleService nService = new ArticleService();
			
			List list = nService.getArticleList();
			
			FileService fService = new FileService();
			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
			for(int i = 0;i<list.size();i++)
			{
				Article article = (Article)list.get(i);
				
				out.println("<div class=\"text\">");
	        	out.println("<div class=\"title\">标题：<a href=\"#\">"+article.getTitle()+"</a></div>");
	        	out.println("<div class=\"cont\"><p>"+ fService.getAbstract(realPath+article.getPath())+"</p></div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}