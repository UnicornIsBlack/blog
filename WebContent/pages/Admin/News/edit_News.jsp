<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chai.blog.pojo.*" errorPage="error.jsp"%>
<%@page import="com.chai.blog.service.FileService"%>
<%@page import="com.chai.blog.service.NewsService"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/content.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<SCRIPT language=javascript>
		function CheckForm()
		{
			if(document.news_form.title.value=="")
			{
				alert("请输入标题！");
				return false;
			}
			if(document.news_form.content.value == "")
			{
				alert("请输入内容！");
				return false;
			}
			document.news_form.submit();
		}
	</SCRIPT>

<body topmargin="30">
	<%
		String id = (String) request.getParameter("news_id");
		int ID = Integer.parseInt(id);
		NewsService nService = new NewsService();
		News news = nService.getNewsById(ID);
		
		FileService fService = new FileService();
		
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
	%>
	<div align="center" class="all">
		<div class="wrap">
			<div class="container">
				<div class="content">
					<form name="news_form" action="<%=path %>/NewsEditServlet"
						method="post">
						<div>
							<font class="title_2">新闻编辑</font>
						</div>
						<br>
						<div>
							标题:<input type="text" name="title" class="textBox"
								value="<%=news.getTitle()%>"> <input type="hidden"
								name="news_id" value="<%=id%>">
						</div>
						<br>
						<div>
							内容:
							<textarea name="content" cols="50" rows="6"><%=fService.getAbstract(realPath+news.getPath())%></textarea>
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