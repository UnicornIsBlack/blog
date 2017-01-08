<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = (String)request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<%=path %>/pages/Admin/css/content.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
	</head>
<SCRIPT language=javascript>
		function CheckForm() {
			if (document.loginForm.username.value == "") {
				alert("请输入用户名！");
				document.loginForm.username.focus();
				return false;
			}
			if (document.loginForm.password.value == "") {
				alert("请输入密码！");
				document.loginForm.password.focus();
				return false;
			}
			document.loginForm.submit();
		}
	</SCRIPT>
<body>
	<div class="all">
		<form name="loginForm" method="post" action="<%=path%>/LoginServlet">
			<div class="mydiv">
				<div class="container">
					<div class="content">
						<h1>登录界面</h1>
						用户名: <input type="text" name="username" class="textBox"><br>
						<br> 密&nbsp;&nbsp;码: <input type="password" name="password"
							class="textBox"><br> <br>
						<input type="button" name="Submit" value="提交"
							onClick="CheckForm()">
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>