<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="control" prefix="control"%>

<%
	String pageStr = (String)request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/content.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="all">
		<form id="form1" runat="server">
			<div class="wrap">
				<div class="container">
					<div class="content">
						<control:NewsListAdminTaglib />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>