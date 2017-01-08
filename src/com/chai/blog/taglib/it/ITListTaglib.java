package com.chai.blog.taglib.it;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.IT;
import com.chai.blog.service.FileService;
import com.chai.blog.service.ITService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.http.HttpServletRequest;

public class ITListTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
			
			ITService nService = new ITService();
			
			List list = nService.getITList();
			
			FileService fService = new FileService();
			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
			for(int i = 0;i<list.size();i++)
			{
				IT it = (IT)list.get(i);
				
				out.println("<div class=\"text\">");
	        	out.println("<div class=\"title\">标题：<a href=\"#\">"+it.getTitle()+"</a></div>");
	        	out.println("<div class=\"cont\"><p>"+ fService.getAbstract(realPath+it.getPath())+"</p></div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}