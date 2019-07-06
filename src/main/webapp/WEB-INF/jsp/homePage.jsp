<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
	<!-- 适应各种分辨率的屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style type="text/css">
	body {
		padding-top: 50px;
		padding-left: 50px;
	}
</style>
</head>
<body>
     
	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">晶天美食</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="toHomePage.do"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
				<li><a href="toShoppingCart.do"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a></li>
				<li><a href="#support"><span class="glyphicon glyphicon-headphones"></span> Support</a></li>
			</ul>	
			<a><span class="glyphicon glyphicon-user" style="position: absolute;right: 100px;top: 15px;color: white;">&nbsp;${username}</span></a>	
			<a href="loginOut.do"><span class="glyphicon glyphicon-off" style="position: absolute;right: 30px;top: 15px;color: white;">退出</span></a>
		</div>
	</div>
	</div>	
	<div>		
	</div>
</body>
</html>