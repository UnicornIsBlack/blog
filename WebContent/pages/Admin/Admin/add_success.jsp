<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style>
		.divcss-right {
			float: right;
		}
		</style>
		<link href="<%=path %>/pages/Admin/css/content.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="all">
			<form id="form1" runat="server">
				<div class="wrap">
					<div class="container">
						<h2 align="center">成功信息</h2>
						<div class="content">
							<h4 align="center">管理员修改成功</h4>
							<br>
							<br>
							<div class="divcss-right">
								<a href="./pages/Admin/Admin/admin_add.jsp">&lt;&lt;返回上一页</a>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>