package com.chai.blog.taglib.book;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.Book;
import com.chai.blog.service.FileService;
import com.chai.blog.service.BookService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.http.HttpServletRequest;

public class BookListAdminTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
			
			BookService bookService = new BookService();
			
			List list = bookService.getBookList();
			
			FileService fService = new FileService();
			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
			for(int i = 0;i<list.size();i++)
			{
				Book book = (Book)list.get(i);
				
				out.println("<div class=\"text\">");
	        	out.println("<div class=\"title\">邮箱："+book.getEmail()+"</div>");
	        	out.println("<div class=\"func1\"><a href=\"edit_Book.jsp?book_id="+book.getId()+"\">[编辑]</a>" +"&nbsp;<a href=\"delete_Book.jsp?book_id="+book.getId()+" \"onclick=\"{if(confirm(\'确定删除该新闻？\')){return true;}return false;}\">[删除]</a></div></div>");
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