package com.chai.blog.taglib;

import java.util.List;


import javax.servlet.jsp.tagext.TagSupport;

import com.chai.blog.pojo.Admin;

import com.chai.blog.service.AdminService;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class AdminListTaglib extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
	
		try 
		{
			AdminService adminService = new AdminService();
			
			
			List list = adminService.getAdminList();
			
			
			for(int i = 0;i<list.size();i++)
			{
				Admin admin = (Admin)list.get(i);
				
				out.println("<div class=\"text\">");
				out.println("用户名："+admin.getUsername()+"密码："+admin.getPassword());
	        	out.println("<div class=\"func1\"><a href=\"edit_Admin.jsp?username="+admin.getUsername()+"\">[编辑]</a>" +"&nbsp;<a href=\"delete_Admin.jsp?username="+admin.getUsername()+" \"onclick=\"{if(confirm(\'确定删除该新闻？\')){return true;}return false;}\">[删除]</a></div></div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}