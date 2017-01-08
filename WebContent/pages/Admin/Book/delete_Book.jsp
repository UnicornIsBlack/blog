<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chai.blog.pojo.*,com.chai.blog.service.*" errorPage="error.jsp"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除留言</title>
</head>
<body>
	<% 
		String ID = (String)request.getParameter("book_id"); 		 
	    int id = Integer.parseInt(ID);
	    BookService bookService = new BookService();
	    
	    boolean flag = bookService.deleteBook(id);
	    
	    if(flag == true)
	    {
	    	%>
	    	<SCRIPT language=javascript>
				alert("该留言已删除!");	
				location.href='<%=path%>/pages/Admin/Book/book_list.jsp';	
			</SCRIPT>
	    	<%
	    }
	
	%>
	
</body>
</html>