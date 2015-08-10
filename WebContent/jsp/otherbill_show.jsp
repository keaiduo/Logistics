<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>搜索表单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bs3/dpl.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bs3/bui.css" rel="stylesheet">

<link href="css/bs3/dpl.css" rel="stylesheet">
<link href="css/bs3/bui.css" rel="stylesheet">
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
		method="post" action="otherbill_search" namespace="/">
		<div class="container">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">日期：</label>
					<div class="controls">
						<input id="odate" name="odate" type="text"
							class="input-normal control-text" />
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">业务状况：</label>
					<div class="controls">
						<input id="obiz" name="obiz" type="text"
							class="input-normal control-text" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">经手人：</label>
					<div id="range" class="controls bui-form-group"
						data-rules="{dateRange:true}">
						<input id="obroker" name="obroker"  type="text">
					</div>
				</div>
				<div class="span3 offset2">
					<button type="submit" id="btnSearch" class="button button-primary">搜索</button>
				</div>
			</div>
			<div class="search-grid-container">
				<div id="grid"></div>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>

	<script type="text/javascript">
		$(function() {
			prettyPrint();
		});
	</script>
	<div class="demo-content">
		<table cellspacing="0" class="table table-bordered">
			<tr>
				<td class="controls">日期</td>
				<td>公司</td>
				<td>业务状况</td>
				<td>数量</td>
				<td>事由</td>
				<td>利润</td>
				<td>经手人</td>
				<td>操作</td>

			</tr>
			<c:forEach items="${requestScope.lstOtherbills }" var="Otherbill"
				varStatus="loop">
				<tr>
					<td>${Otherbill.odate }</td>
					<td>${Otherbill.ocompany}</td>
					<td>${Otherbill.obiz }</td>
					<td>${Otherbill.oquantity}</td>
					<td>${Otherbill.oreason}</td>
					<td>${Otherbill.oprofit }</td>
					<td>${Otherbill.obroker }</td>
					<td><a href="otherbill_edit.action?oid=${Otherbill.oid}">编辑</a>
						<a href="otherbill_delete.action?oid=${Otherbill.oid}" onclick="return delcfm()">删除</a>
					</td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<script type="text/javascript">
	function delcfm(){
		if(!confirm("确定删除此项记录吗")){
			window.event.returnValue = false;
		}
	}
	</script>
	
<body>
</html>
