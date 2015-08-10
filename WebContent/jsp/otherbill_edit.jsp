<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>资源文件结构</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />



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
<c:if test="${!empty otherbill}"  >
	<form id="J_Form" class="form-horizontal span24" name="form"
		method="post" action="otherbill_update?oid=${otherbill.oid}" namespace="/">
		
		<div class="container">
			<div class="row">
					<div class="row">
						<div class="control-group span8">
							<label class="control-label"><s>*</s>日期：</label>
							<div id="range" class="controls bui-form-group"
								data-rules="{dateRange:true}">
								<input id="odate" name="odate" class="calendar"
									data-rules="{required:true}" type="text" value="${otherbill.odate}">
							</div>
						</div>
						<div class="control-group span8">
							<label class="control-label">公司：</label>
							<div class="controls">
								<input id="ocompany" name="ocompany" type="text"
									class="input-normal control-text" value="${otherbill.ocompany}"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="control-group span8">
							<label class="control-label">业务状况：</label>
							<div class="controls">
								<input id="obiz" name="obiz" type="text"
									class="input-normal control-text" value="${otherbill.obiz}">
							</div>
						</div>
						<div class="control-group span8">
							<label class="control-label">数量：</label>
							<div class="controls">
								<input id="oquantity" name="oquantity" type="text"
									class="input-normal control-text" value="${otherbill.oquantity}">
							</div>
						</div>

					</div>
					<div class="row">
						<div class="control-group span15">
							<label class="control-label">事由：</label>
							<div class="controls control-row4">
								<input name="oreason" class="input-large" id="oreason"
									data-tip="{text:'请填写事由信息！'}" type="text" value="${otherbill.oreason}">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="control-group span8">
							<label class="control-label">利润：</label>
							<div class="controls">
								<input id="oprofit" name="oprofit" type="text"
									class="input-normal control-text" value="${otherbill.oprofit}">
							</div>
						</div>
						<div class="control-group span8">
							<label class="control-label">经手人：</label>
							<div class="controls">
								<input id="obroker" name="obroker" type="text"
									class="input-normal control-text" value="${otherbill.obroker}">
							</div>
						</div>
					</div>									
					<div class="row form-actions actions-bar">
						<div class="span13 offset3 ">
							<button type="submit" class="button button-primary">保存</button>
							<button type="reset" class="button">重置</button>
						</div>
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
	<!-- 仅仅为了显示代码使用，不要在项目中引入使用-->
	<script type="text/javascript" src="../assets/js/prettify.js"></script>
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
	</c:if>
<body>
</html>
