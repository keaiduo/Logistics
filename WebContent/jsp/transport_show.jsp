<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>搜索表单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/prettify.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bs3/dpl.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bs3//bui.css" rel="stylesheet">


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
		method="post" action="transport_search" namespace="/">
		<div class="container">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">专线单号：</label>
					<div class="controls">
						<input id="tno" name="tno" type="text"
							class="input-normal control-text" />
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">公司单号：</label>
					<div class="controls">
						<input id="tgsdh" name="tgsdh" type="text"
							class="input-normal control-text" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">提货车号：</label>
					<div id="range" class="controls bui-form-group"
						data-rules="{dateRange:true}">
						<input id="tthch" name="tthch"  type="text">
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
				<td class="controls">专线单号</td>
				<td>专线名称</td>
				<td>专线地址</td>
				<td>联系人</td>
				<td>联系电话</td>
				<td>查货电话</td>
				<td>单价</td>
				<td>专线费</td>
				<td>送货费</td>
				<td>提货费</td>
				<td>提货车号</td>
				<td>提货人</td>
				<td>司机电话</td>
				<td>提货成本</td>
				<td>公司单号</td>
				<td>操作</td>

			</tr>
			<c:forEach items="${requestScope.lstTransports }" var="Transport"
				varStatus="loop">
				<tr>
					<td>${Transport.tno }</td>
					<td>${Transport.tname}</td>
					<td>${Transport.taddr }</td>
					<td>${Transport.tlxt}</td>
					<td>${Transport.tlxdh}</td>
					<td>${Transport.tchdh }</td>
					<td>${Transport.tprice }</td>
					<td>${Transport.tzxf}</td>
					<td>${Transport.tshf }</td>
					<td>${Transport.tthf }</td>
					<td>${Transport.tthch }</td>
					<td>${Transport.tthr }</td>
					<td>${Transport.tsjdh }</td>
					<td>${Transport.tthcb }</td>
					<td>${Transport.tgsdh }</td>
					<td><a href="transport_edit.action?tid=${Transport.tid}">编辑</a>
						<a href="transport_delete.action?tid=${Transport.tid}" onclick="return delcfm()">删除</a>
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
