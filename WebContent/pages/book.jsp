<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="control" prefix="control"%>
<%@ page import="com.chai.blog.pojo.*,com.chai.blog.service.*" errorPage="error.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<%=path%>/CSS/index.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>留言板</title>
	</head>
<SCRIPT language=javascript>
	function CheckForm() {
		if (document.bookForm.email.value == "") {
			alert("请输入邮箱！");
			document.bookForm.email.focus();
			return false;
		}
		if (document.bookForm.content.value == "") {
			alert("请输入留言！");
			document.bookForm.content.focus();
			return false;
		}
		document.bookForm.submit();
	}
</SCRIPT>
<body>
	<div id="all" style="width: 100%">
		<form id="form2" name="bookForm" method="post"	action="<%=path%>/BookAddServlet">

			<div id="wrap">
				<div id="container">
					<div id="content">
						<h1>留言板</h1>
						<br> 邮箱:<input type="text" name="email" class="textBox"><br>
						<br> 留言:
						<textarea name="content" cols="50" rows="5"></textarea>
						<br>
						<br> <input type="button" name="Submit" value="提交"
							onClick="CheckForm()">
					</div>
				</div>
			</div>
		</form>
		<form id="form2" runat="server">
			<div id="wrap">
				<div id="container">
					<div id="content">
						<h1>留言</h1>
						<br>
						<br>
						<br>
						<control:BookListTaglib />
					</div>
				</div>
			</div>
		</form>
		<br/>
		<br/>
		<br/>
		<br/>
		
	</div>
</body>
</html>