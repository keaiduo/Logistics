<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>业务清单导出</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/prettify.css" rel="stylesheet" type="text/css" />
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
	<form id="J_Form" class="form-horizontal span24" method="post"
		action="bizlistExportAction" namespace="/">
		<div class="container">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">客户公司选择：</label>
					<div class="controls">
						<select class="input-normal" id="companyname" name="companyname">
							<option value="">请选择</option>
							<c:forEach items="${requestScope.lstCompanys }" var="Company">
								<option value="${Company.cname}" name="companyname">${Company.cname}</option>
							</c:forEach>

						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span9">
					<label class="control-label">日期选择：</label>
					<div id="range" class="controls bui-form-group"
						data-rules="{dateRange:true}">
						<input id="startDate" name="startDate" class="calendar"
							type="text"> <span> - </span> <input id="endDate"
							name="endDate" type="text" class="calendar">
					</div>
				</div>
			</div>
			<div class="row form-actions actions-bar">
				<div class="span13 offset3 ">
					<button type="submit" id="btnSearch" class="button button-primary">导出</button>
				</div>
			</div>

		</div>
	</form>


	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>

	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<script type="text/javascript">
		$(function() {
			prettyPrint();
		});
	</script>
	<script type="text/javascript">
		BUI.use('bui/form', function(Form) {
			var form = new Form.HForm({
				srcNode : '#J_Form'
			});

			form.render();
		});
	</script>
<body>
</html>
