<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chai.blog.pojo.*,com.chai.blog.service.*" errorPage="error.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<%=path %>/pages/Admin/css/content.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<SCRIPT language=javascript>
		function CheckForm()
		{
			if(document.edit_manager_Form.password.value=="")
			{
				alert("请输入密码!");			
				return false;
			}
			document.edit_manager_Form.submit();
		}
	</SCRIPT>
	<body>
		<%
			String username = (String) request.getParameter("username");
			Admin admin = new Admin();
			
			AdminService adminService = new AdminService();
			
			admin = adminService.getAdmin(username);
		%>
		<div align="center" class="all">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<form name="edit_manager_Form" method="post"
							action="<%=path %>/AdminEditServlet">
							<div>
								<font class="title_2">管理员编辑</font>
							</div>
							<br>
							<div>
								登录名:<%=admin.getUsername()%>
								<input type="hidden" name="username"
									value="<%=admin.getUsername()%>">
							</div>
							<br>
							<div>
								密码:<input name="password" type="text" class="textBox"
									value="<%=admin.getPassword() %>">
							</div>
							<br>
							<div>
								<input type="button" name="Submit" value="提交"
									onClick="CheckForm()">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	
	</body>
</html>