<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<form class="form-horizontal" role="form" action="checkUsername.do" method="post">
		<div class="container" style="position: absolute;left: 40%;top: 30%;">		
  		<div class="form-group">
    		<label>用户名</label>
    		<input id="username" name="username" class="form-control" placeholder="Username" style="width: 400px;" onblur="checkUsername()">
    		<span id="checkUsershow" class="label label-danger">${msg}</span>
  		</div>
  		<div class="form-group">
    		<label >密码</label>
    		<input type="password" name="password" class="form-control" placeholder="Password" style="width: 400px;">
  		</div>
  		<span id="checkUsershow" class="label label-success">${success}</span><br/><br/>
  		<button id="btn-login" type="submit" class="btn btn-primary">注册</button>		
		</div>
	</form>
	<script>
		function checkUsername(){
		var user = document.getElementById('username').value;
		if(user == null || user == ""){
			$('#checkUsershow').text("用户名不能为空");
			$('#btn-login').prop("disabled","disabled");
		}else{
			$('#btn-login').removeAttr("disabled");
			$('#checkUsershow').empty();
		}
	}
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>