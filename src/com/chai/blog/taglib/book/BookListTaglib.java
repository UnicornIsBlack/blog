package com.chai.blog.taglib.book;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.Book;
import com.chai.blog.service.FileService;
import com.chai.blog.service.BookService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.http.HttpServletRequest;

public class BookListTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
			
			BookService nService = new BookService();
			
			List list = nService.getBookList();
			
			FileService fService = new FileService();
			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
			for(int i = 0;i<list.size();i++)
			{
				Book book = (Book)list.get(i);
				
				out.println("<div class=\"text\">");
	        	out.println("<div class=\"title\">邮箱："+book.getEmail()+"</div>");
	        	out.println("<div class=\"cont\"><p>"+ fService.getContent(realPath+book.getPath())+"</p></div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}