<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="easyui_1.4.4/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="easyui_1.4.4/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="easyui_1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="easyui_1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui_1.4.4/jquery.edatagrid.js"></script>
<script type="text/javascript"
	src="easyui_1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script src="js/js.js" type="text/javascript" charset="utf-8"></script>
<title>菜品种类列表</title>
</head>
<body>
	<div class="content">
		<div class="content-headtab">
			<p>
				菜品种类列表 <span> <a href="#" class="c-tianjia"
					onclick="javascript:$('#tj-cpzl').dialog('open')">[添加菜品种类]</a>
					<div id="tj-cpzl" class="easyui-dialog" modal="true"
						closable="false" closed="true" title="添加菜品种类信息"
						style="width: 400px; height: 300px; background: #fff; overflow: hidden;">
						<form id="addcpzl" action="addcatelogservlet" method="post">
							<div class="w-index">
								<label class="w-label-1">菜品种类：</label> <input class="w-itext"
									id="tjcpzlinfo" type="text" name="cateloginfo" value=""
									placeholder="请输入菜品种类信息" />
							</div>
							<div class="w-index">
								<label class="w-label-1">菜品种类信息：</label> <input class="w-itext"
									id="tjcpzlname" type="text" name="catelogname" value=""
									placeholder="请输入菜品种类" />
							</div>
							<div class="w-index"
								style="text-align: center; margin-top: 30px;">
								<input class="w-but1" type="button" value="提交" id="subbutcpzl" />
								<input class="w-but1" type="button" onclick="d_close_tj()"
									value="返回" />
							</div>
						</form>
					</div>
				</span>
			</p>
			<p>
				当前共计<span>0</span>个账户，分为4页 <span class="content-tabye">转到： <select
					class="content-select">
						<option>1/4</option>
						<option>2/4</option>
						<option>3/4</option>
						<option>4/4</option>
				</select>
				</span>
			</p>
		</div>
		<div class="content-foot">
			<div class="content-sub">
				<form>
					<label class="c-label">关键字：</label> <input type="text"
						class="c-text" value="" placeholder="请输入关键字" id="query" name="query"/> <input
						type="button" class="c-but" value="查询" id="querybutton"
						name="querybutton" />
				</form>
			</div>
			<div class="content-tab">
				<table>
					<tr>
						<th width=22%>编号</th>
						<th width=22%>菜品种类</th>
						<th width=22%>菜品种类信息</th>
						<th width=12%>操作</th>
					</tr>
					<c:forEach items="${list }" var="catelog">
						<tr>
							<td>${catelog.id}</td>
							<td>${catelog.catelogname}</td>
							<td>${catelog.cateloginfo}</td>
							<td><span> <a class="c-taba" href="#"
									onclick="tanchuang('${catelog.id}')">修改</a>
									<div id="xg-cpzl" class="easyui-dialog" modal="true"
										closable="false" closed="true" title="修改菜品类别信息"
										style="width: 400px; height: 300px; background: #fff; overflow: hidden;">
										<form id="updatecpzl" action="upadatecatelogaction"
											method="post">
											<div class="w-index" style="display: none">
												<label class="w-label-1">编号：</label> <input class="w-itext"
													type="text" id="xg-id" name="id" placeholder="请输入编号" />
											</div>
											<div class="w-index">
												<label class="w-label-1">菜品种类：</label> <input
													class="w-itext" type="text" name="catelogname" value=""
													id="xgcpzlinfo" placeholder="请输入菜品种类" />
											</div>
											<div class="w-index">
												<label class="w-label-1">菜品种类信息：</label> <input
													class="w-itext" type="text" name="cateloginfo" value=""
													id="xgcpzlname" placeholder="请输入菜品种类信息" />
											</div>
											<div class="w-index"
												style="text-align: center; margin-top: 30px;">
												<input class="w-but1" type="submit" value="提交"
													id="submitxgcpzl" /> <input class="w-but1" type="button"
													onclick="d_close()" value="返回" />
											</div>
										</form>
									</div> / <a class="c-taba" onclick="remove()"
									href="deletecatelogaction?id=${catelog.id}">删除</a>
							</span></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="c-foot">
				<p>1/1</p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function remove() {
		if (confirm("是否删除该数据？")) {
			alert("该数据已被删除");
		} else {
			alert("该操作已取消！");
		}
	}

	function d_close_tj() {
		$("#tj-cpzl").dialog('close');
		$("#tj-form").form('clear');
	}

	function d_close() {
		//关闭窗口
		$("#xg-cpzl").dialog('close');
		//清除表单缓存
		$("#xg-form").form('clear');
	}

	//添加菜品种类事件
	$("#subbutcpzl").click(
			function() {
				if ($("#tjcpzlinfo").val().length == 0
						|| $("#tjcpzlname").val().length == 0) {
					alert("输入框不能为空");
				} else {
					$("#addcpzl").submit();
				}
			});

	// 修改菜品种类事件
	$("#submitxgcpzl").click(
			function() {
				if ($("#xgcpzlinfo").val().length == 0
						|| $("#xgcpzlname").val().length == 0) {
					alert("输入框不能为空");
				} else {
				}
			});

	function tanchuang(id) {
		$("#xg-id").val(id);
		$('#xg-cpzl').dialog('open');
	}
	
	//查询菜品种类事件
	$("#querybutton").click(function(){
		location.href="selectcatelogbyidservlet?id="+$("#query").val();
	});
</script>
</html>