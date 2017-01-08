<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chai.blog.pojo.*,com.chai.blog.service.*" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除文章</title>
</head>
<body>
	<% 
		String ID = (String) request.getParameter("article_id");
		int id = Integer.parseInt(ID);
		
		ArticleService articleService = new ArticleService();
		
		boolean flag = articleService.deleteArticle(id);
		if(flag == true)
		{
			%>
			<SCRIPT language=javascript>
				alert("该文章已删除!");	
				location.href='./article_list.jsp';	
			</SCRIPT>
			<%
		}
	%>
	
</body>
</html>