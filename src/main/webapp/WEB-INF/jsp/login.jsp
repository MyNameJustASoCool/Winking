<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<div style="padding: 100px 100px 10px;text-align: center;">
	<form action="loginUser.do" method="post" class="bs-example bs-example-form" role="form">
		<div class="input-group input-group-lg container" style="width: 500px;">
			<span class="input-group-addon glyphicon glyphicon-user"></span>
			<input name="username" type="text" class="form-control" placeholder="请输入用户名">
		</div><br>
		<div class="input-group input-group-lg container" style="width: 500px;">
			<span class="input-group-addon glyphicon glyphicon-lock"></span>
			<input name="password" type="password" class="form-control" placeholder="请输入密码">
		</div><br>
		<span class="label label-danger">${msg}</span><br/>
		<div style="text-align: center;">
			<button type="submit" style="width: 80px;text-align: center;" class="btn btn-default">登录</button>
			<a href="toRegister.do">&nbsp;&nbsp;&nbsp;&nbsp;注册</a>
		</div>
	</form>
	</div>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>