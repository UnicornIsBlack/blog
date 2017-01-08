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
			if(document.add_it_Form.title.value=="")
			{
				alert("请输入标题！");
				return false;
			}
			if(document.add_it_Form.content.value == "")
			{
				alert("请输入内容！");
				return false;
			}
			document.add_it_Form.submit();
		}
	</SCRIPT>
	<body topmargin="100">
		<div align="center" class="all">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<form name="add_it_Form" action="<%=path %>/ITAddServlet">
							<div>
								<font class="title_2">添加IT信息</font>
							</div>
							<br>
							<div>
								标题:<input type="text" name="title">
							</div>
							<br>
							<div>
								内容:
								<textarea name="content" cols="50" rows="5"></textarea>
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