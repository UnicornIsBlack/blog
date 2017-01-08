<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<%
		String username = (String)  request.getSession().getAttribute("username");
		System.out.println("username=="+username);
		if (username == null || username.equals(""))
		{
			response.sendRedirect("login/login.jsp");
		}
	%>
<frameset rows="25,*" border=0 frameborder="YES" name="top_frame">
	<frame src="TopFrame.jsp" noresize frameborder="NO" name="ads"
		scrolling="NO" marginwidth="0" marginheight="0">
	<frameset rows="675" cols="210,*" border=0 name="down_frame">
		<frame src="LeftFrame.jsp" noresize name="list" marginwidth="0"
			marginheight="0">
		<frame src="RightFrame.jsp" name="main" marginwidth="0"
			marginheight="0">
	</frameset>
</frameset>
<noframes>
</noframes>
</html>