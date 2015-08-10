

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bs3/dpl.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bs3//bui.css" rel="stylesheet">


<link href="css/bs3/dpl.css" rel="stylesheet">
<link href="css/bs3/bui.css" rel="stylesheet">
<script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="../assets/js/config-min.js"></script>
<script type="text/javascript" src="../assets/js/config-min.js"></script>
<style type="text/css">
code {
	padding: 0px 4px;
	color: #d14;
	background-color: #f7f7f9;
	border: 1px solid #e1e1e8;
}
</style>
</head>
<body>
	<form id="searchForm" class="form-horizontal span24" name="form"
		method="post" action="company_add" namespace="/">
		<div class="container">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">客户公司名称：</label>
					<div class="controls">
						<input id="cname" name="cname" type="text"
							class="input-normal control-text" />
					</div>
				</div>				
			</div>
			<div class="row">
			<div class="row form-actions actions-bar">
					<div class="span13 offset3 ">
						<button type="submit" class="button button-primary">添加</button>
						<button type="reset" class="button">重置</button>
					</div>
				</div>
			</div>
			
		</div>
	</form>
</body>
</html>
