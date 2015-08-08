<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="lg">
		<form action="#" method="POST">
			<div class="lg_top"></div>
			<div class="lg_main">
				<div class="lg_m_1">

					<input name="username" placeholder="用户名" value="" class="ur" />
					<input name="password" placeholder="密码" type="password" value="" class="pw" />

				</div>
			</div>
			<div class="lg_foot">
				<input type="submit" value="登录" class="bn" />
			</div>
		</form>
	</div>
</body>
</html>