<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>资源文件结构</title>
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
<c:if test="${!empty bizlist}"  >
	<form id="J_Form" class="form-horizontal span24" name="form"
		method="post" action="bizlist_update?bid=${bizlist.bid}" namespace="/">
		<div class="container">
			<div class="row">

				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>公司单号：</label>
						<div class="controls">
							<input id="orderno" name="orderno" type="text"
								 class="input-normal control-text" value="${bizlist.orderno}"/>
						</div>
					</div>

					<div class="control-group span8">
						<label class="control-label">客户公司名称：</label>
						<div class="controls">
						<input id="companyname" name="companyname" type="text"
								 class="input-normal control-text" value="${bizlist.companyname}"/>					
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">客户单号：</label>
						<div class="controls">
							<input id="clientno" name="clientno" type="text"
								class="input-normal control-text" value="${bizlist.clientno}"/>
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">发货日期：</label>
						<div id="range" class="controls bui-form-group"
							data-rules="{dateRange:true}">
							<input id="startdate" name="startdate" class="calendar" 
								 type="text" value="${bizlist.startdate}">
						</div>
					</div>
				
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">件数：</label>
						<div class="controls">
							<input id="number" name="number" type="text"
								class="input-normal control-text" data-rules="{number:true}"
								value="${bizlist.number}">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">数量：</label>
						<div class="controls">
							<input id="quantity" name="quantity" type="text" data-rules="{number:true}"
								class="input-normal control-text" value="${bizlist.quantity}">
						</div>
					</div>

				</div>
				<div class="row">

					<div class="control-group span8">
						<label class="control-label">单位：</label>
						<div class="controls">
							<input id="unit" name="unit" type="text"
								class="input-normal control-text" value="${bizlist.unit}">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">渠道：</label>
						<div class="controls">
							<input id="channel" name="channel" type="text"
								class="input-normal control-text" value="${bizlist.channel}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">始发地：</label>
						<div class="controls">
							<input id="startlocation" name="startlocation" type="text"
								class="input-normal control-text" value="${bizlist.startlocation}">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">收货单位：</label>
						<div class="controls">
							<input id="endcompany" name="endcompany" type="text"
								class="input-normal control-text" value="${bizlist.endcompany}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">收货人：</label>
						<div class="controls">
							<input id="receiver" name="receiver" type="text"
								class="input-normal control-text" value="${bizlist.receiver}">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">收货地址：</label>
						<div class="controls">
							<input id="endlocation" name="endlocation" type="text"
								class="input-normal control-text" value="${bizlist.endlocation}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">收货电话：</label>
						<div class="controls">
							<input id="telephone" name="telephone" type="text" data-rules="{number:true}"
								class="input-normal control-text" value="${bizlist.telephone}">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">运费总额</label>
						<div class="controls">
							<input id="totalfee" name="totalfee" type="text" data-rules="{number:true}"
								class="input-normal control-text"  value="${bizlist.totalfee}">
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
