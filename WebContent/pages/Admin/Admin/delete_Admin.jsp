<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.chai.blog.pojo.*,com.chai.blog.service.*" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Delete</title>
	</head>
	<body>
		<%
			String username = (String) request.getParameter("username");
			AdminService adminService = new AdminService();
			
			boolean flag = adminService.deleteAdmin(username);
			if(flag == true)
			{
				%>
				<SCRIPT language=javascript>	
					alert("该管理员已删除!");		
					location.href='./admin_list.jsp';	
				</SCRIPT>
				<%
			}
		%>
		
	</body>
</html>