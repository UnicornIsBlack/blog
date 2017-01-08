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
			if(document.article_form.title.value=="")
			{
				alert("请输入标题！");
				return false;
			}
			if(document.article_form.content.value == "")
			{
				alert("请输入内容！");
				return false;
			}
			document.article_form.submit();
		}
	</SCRIPT>
	
	<body topmargin="30">
		<%
			String ID = (String) request.getParameter("article_id");
			int id = Integer.parseInt(ID);
			
			Article article = new Article();
			ArticleService articleService = new ArticleService();
			
			article = articleService.getArticleById(id);
			
			FileService fService = new FileService();			
			String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		%>
		<div align="center" class="all">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<form name="article_form" action="<%=path %>/ArticleEditServlet"
							method="post">
							<div>
								<font class="title_2">文章编辑</font>
							</div>
							<br>
							<div>
								标题:<input type="text" name="title" class="textBox"
									value="<%=article.getTitle()%>"> <input type="hidden"
									name="article_id" value="<%=id%>">
							</div>
							<br>
							<div>
								内容:
								<textarea name="content" cols="50" rows="6"><%=fService.getAbstract(realPath+article.getPath()) %></textarea>
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