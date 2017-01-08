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
			if(document.it_form.title.value=="")
			{
				alert("请输入标题！");
				return false;
			}
			if(document.it_form.content.value == "")
			{
				alert("请输入内容！");
				return false;
			}
			document.it_form.submit();
		}
	</SCRIPT>

	<body topmargin="30">
		<%
			String ID = (String) request.getParameter("it_id");
			int id = Integer.parseInt(ID);
			IT it = new IT();
			ITService itService = new ITService();
			
			it = itService.getITById(id);
			
			FileService fService = new FileService();			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
			
		%>
		<div align="center" class="all">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<form name="it_form" action="<%=path %>/ITEditServlet" method="post">
							<div>
								<font class="title_2">IT信息编辑</font>
							</div>
							<br>
							<div>
								标题:<input type="text" name="title" class="textBox"
									value="<%=it.getTitle()%>"> <input type="hidden"
									name="it_id" value="<%=id%>">
							</div>
							<br>
							<div>
								内容:
								<textarea name="content" cols="50" rows="6"><%=fService.getAbstract(realPath+it.getPath()) %></textarea>
							</div>
							<br>
							<div>
								<input type="button" name="Submit" value="保存修改"
									onClick="CheckForm()">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>