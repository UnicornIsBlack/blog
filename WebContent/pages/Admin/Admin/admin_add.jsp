<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			if(document.add_manager_Form.name.value=="")
			{
				alert("请输入登录名!");
				return false;
			}
			if(document.add_manager_Form.password.value=="")
			{
				alert("请输入密码!");
				
				return false;
			}
			document.add_manager_Form.submit();
		}
	</SCRIPT>
	<body>
		<div align="center" class="all">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<form name="add_manager_Form" method="post"
							action="<%=path%>/AdminAddServlet">
							<div>
								<font class="title_2">添加管理员</font>
							</div>
							<br>
							<div>
								登录名:<input name="username" type="text" id="name" class="textBox">
							</div>
							<br>
							<div>
								密码:<input name="password" type="password" class="textBox">
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