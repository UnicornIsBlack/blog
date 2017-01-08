package com.chai.blog.taglib.news;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.News;
import com.chai.blog.service.FileService;
import com.chai.blog.service.NewsService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.http.HttpServletRequest;

public class NewsListTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
			
			NewsService nService = new NewsService();
			
			List list = nService.getNewsList();
			
			FileService fService = new FileService();
			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
			for(int i = 0;i<list.size();i++)
			{
				News news = (News)list.get(i);
				
				out.println("<div class=\"text\">");
	        	out.println("<div class=\"title\">标题：<a href=\"#\">"+news.getTitle()+"</a></div>");
	        	out.println("<div class=\"cont\"><p>"+ fService.getAbstract(realPath+news.getPath())+"</p></div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}