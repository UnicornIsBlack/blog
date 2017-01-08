<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = (String)request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top</title>
<link href="<%=path %>/CSS/head.css" type="text/css" rel="stylesheet">
</head>
<body>
	<figure>
	<p>
		<audio src="<%=path %>/Music/JJ.mp3" controls="controls" hidden="true"
			autoplay="true" loop="true"> </audio>
		<a class="emails" target="_blank" title="email to me!"
			href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=304334894@qq.com"></a>
	</p>
	</figure>
</body>
</html>