<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="control" prefix="control"%>

<%
	String path = (String)request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=path%>/CSS/index.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章</title>
</head>
<body>
	<div id="all" style="width: 100%">
		<form id="form1" runat="server">
			<div id="wrap">
				<div id="container">
					<div id="content">
						<control:ArticleListTaglib />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>