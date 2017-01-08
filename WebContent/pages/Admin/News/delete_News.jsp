<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chai.blog.service.*" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除新闻</title>
</head>
<body>
	<% String ID = (String)request.getParameter("news_id"); 		 
	    int id = Integer.parseInt(ID);
		NewsService nService = new NewsService();
		boolean flag = nService.deleteNews(id);
		if(flag == true)
		{
			%>
			<SCRIPT language=javascript>
				alert("该新闻已删除!");
				location.href='./news_list.jsp';
			</SCRIPT>
			<%
		}
	%>
	
</body>
</html>