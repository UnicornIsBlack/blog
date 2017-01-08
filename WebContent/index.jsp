<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客</title>
<link href="CSS/head.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript" language="javascript">   
	function iFrameHeight() {   
		var ifm= document.getElementById("iframepage");   
		var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
		if(ifm != null && subWeb != null) 
		{
		   ifm.height = subWeb.body.scrollHeight;
		   ifm.width = subWeb.body.scrollWidth;
		}   
	}   
</script>
<body>
	<figure>
	<p>
		<audio src="Music/JJ.mp3" controls="controls" hidden="true"
			autoplay="true" loop="true"> </audio>
		<a class="emails" target="_blank" title="email to me!"
			href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=304334894@qq.com"></a>
	</p>
	</figure>
	<header>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table class="logo">
		<tr>
			<td><img src="images/logo.png" alt="柴孟浩的博客"></td>
		</tr>
	</table>
	</header>
	<div id="nav">
		<ul>
			<li><a href="pages/Home.jsp" target="down">首页</a></li>
			<li><a href="pages/IT.jsp" target="down">IT</a></li>
			<li><a href="pages/Article.jsp" target="down">文章</a></li>
			<li><a href="pages/News.jsp" target="down">新闻</a></li>
			<li><a href="pages/book.jsp" target="down">留言板</a></li>
		</ul>
	</div>
	<iframe id="iframepage" name="down" src="pages/Home.jsp" frameborder="0" scrolling="no" onLoad="iFrameHeight()"></iframe>
</body>
</html>