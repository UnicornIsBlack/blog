<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link href="css/left.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.inactive').click(function(){
			if($(this).siblings('ul').css('display')=='none'){
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);
	
				}
			}else{
				//控制自身变成+号
				$(this).removeClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').slideUp(100);
				//控制自身子菜单变成+号
				$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').children('li').children('ul').slideUp(100);
	
				//控制同级菜单只保持一个是展开的（-号显示）
				$(this).siblings('ul').children('li').children('a').removeClass('inactives');
			}
		})
	});
	</script>
</head>
<body topmargin="0" leftmargin="0" rightmargin="0">
	<div style="text-align: center; clear: both">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
	</div>
	<div class="list">
		<ul class="yiji">
			<li><a href="RightFrame.jsp" target="main">首页</a></li>
			<li><a href="#" class="inactive">文章</a>
				<ul style="display: none">
					<li><a href="Article/article_list.jsp" target="main">查看</a></li>
					<li class="last"><a href="Article/article_add.jsp"
						target="main">添加</a></li>
				</ul></li>
			<li><a href="#" class="inactive">IT</a>
				<ul style="display: none">
					<li><a href="IT/it_list.jsp" target="main">查看</a></li>
					<li class="last"><a href="IT/it_add.jsp" target="main">添加</a>
					</li>
				</ul></li>
			<li><a href="#" class="inactive">新闻</a>
				<ul style="display: none">
					<li><a href="News/news_list.jsp" target="main">查看</a></li>
					<li class="last"><a href="News/news_add.jsp" target="main">添加</a>
					</li>
				</ul></li>
			<li><a href="#" class="inactive">留言板</a>
				<ul style="display: none">
					<li><a href="Book/book_list.jsp" target="main">查看</a></li>
				</ul></li>
			<li><a href="#" class="inactive">管理员</a>
				<ul style="display: none">
					<li><a href="Admin/admin_list.jsp" target="main">查看</a></li>
					<li class="last"><a href="Admin/admin_add.jsp" target="main">添加</a>
					</li>
				</ul></li>
		</ul>
	</div>
</body>
</html>