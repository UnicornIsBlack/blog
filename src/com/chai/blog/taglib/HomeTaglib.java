package com.chai.blog.taglib;


import javax.servlet.jsp.tagext.TagSupport;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class HomeTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
		try 
		{
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
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}