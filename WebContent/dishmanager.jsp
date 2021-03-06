<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品管理</title>
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
<script type="text/javascript" src="js/foodajax.js"></script>
</head>
<body>
	<div class="content">
		<div class="content-headtab">
			<p>
				菜品列表 <span> <a href="#" class="c-tianjia"
					onclick="javascript:$('#tj-admin').dialog('open')">[添加菜品]</a>
					<div id="tj-admin" class="easyui-dialog" modal="true"
						closable="false" closed="true" title="添加菜品信息"
						style="width: 400px; background: #fff; overflow: hidden;">
						<form id="tj-addfoodform" action="addfoodaction" method="post">
							<div class="w-index">
								<label class="w-label-1">菜品名：</label> <input class="w-itext"
									type="text" id="food_name" name="food_name"
									style="width: 200px" value="" placeholder="请输入菜品名" />
							</div>
							<div class="w-index">
								<label class="w-label-1">菜品种类：</label> <select id="food_id"
									name="food_id" style="width: 200px"></select>
							</div>
							<div class="w-index">
								<label class="w-label-1">图片：</label> <input type="file"
									id="photo" name="photo" style="width: 200px">
							</div>
							<div class="w-index">
								<label class="w-label-1">菜品信息：</label> <input type="text"
									id="food_message" name="food_message" style="width: 200px"
									placeholder="请输入菜品信息">
							</div>
							<div class="w-index">
								<label class="w-label-1">单价：</label> <input type="text"
									id="food_price" name="food_price" style="width: 200px"
									placeholder="请输入单价">
							</div>
							<div class="w-index"
								style="text-align: center; margin-top: 30px;">
								<input id="addfoodsub" class="w-but1" type="button" value="提交" />
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
						class="c-text" value="" id="queryid" name="queryid" placeholder="请输入关键字" /> <input
						type="button" class="c-but" id="c-but" value="查询" />
				</form>
			</div>
			<div class="content-tab">
				<table>
					<tr>
						<th>编号</th>
						<th>菜品名</th>
						<th>菜品种类</th>
						<th>图片</th>
						<th>菜品信息</th>
						<th>单价</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${list}" var="food">
						<tr>
							<td>${food.id}</td>
							<td>${food.foodname}</td>
							<td>${food.catelogid}</td>
							<td>${food.photo}</td>
							<td>${food.foodinfo}</td>
							<td>${food.price}</td>
							<td><span> <a class="c-taba" href="#"
									onclick="tanchuang('${food.id}')">修改</a> / <a class="c-taba"
									onclick="remove('${food.id}')" href="#">删除</a>
							</span></td>
						</tr>
					</c:forEach>
				</table>

				<div id="xg-admin" class="easyui-dialog" modal="true"
					closable="false" closed="true" title="修改管理员信息"
					style="width: 400px; background: #fff; overflow: hidden;">
					<form id="xg-adminform" action="changefoodaction" method="post">
						<div class="w-index" style="display: none">
							<label class="w-label-1">编号：</label> <input class="w-itext"
								type="text" id="xg-id" name="id" placeholder="请输入编号" />
						</div>
						<div class="w-index">
							<label class="w-label-1">菜品名：</label> <input class="w-itext"
								type="text" id="foodname1" name="foodname1" placeholder="请输入菜品名"
								width="200px" />
						</div>
						<div class="w-index">
							<label class="w-label-1">菜品种类：</label><select id="catelog_id" name="catelog_id"
								style="width: 200px"></select>
						</div>
						<div class="w-index">
							<label class="w-label-1">图片：</label><input type="file"
								id="picture" name="picture" width="200px">
						</div>
						<div class="w-index">
							<label class="w-label-1">菜品信息：</label> <input type="text"
								id="food_message1" name="food_message1" style="width: 200px"
								placeholder="请输入菜品信息">
						</div>
						<div class="w-index">
							<label class="w-label-1">单价：</label> <input type="text"
								id="food_price1" name="food_price1" style="width: 200px"
								placeholder="请输入单价">
						</div>
						<div class="w-index" style="text-align: center; margin-top: 30px;">
							<input id="xg-but" class="w-but1" type="button" value="提交" /> <input
								class="w-but1" type="button" onclick="d_close()" value="返回" />
						</div>
					</form>
				</div>
			</div>

			<div class="c-foot">
				<p>1/1</p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function remove(id) {
	if (confirm("是否删除改数据？")) {
		location.href="deletefoodaction?id="+id;
	} else {
		alert("该操作已取消！");
	}
}
	function d_close_tj() {
		$("#tj-admin").dialog('close');
		$("#tj-addfoodform").form('clear');
	}

	function d_close() {
		//关闭窗口
		$("#xg-admin").dialog('close');
		//清除表单缓存
		$("#xg-adminform").form('clear');
	}
	$("#addfoodsub").click(
			function() {
				if ($("#food_name").val().length == 0
						|| $("#food_message").val().length == 0
						|| $("#food_price").val().length == 0) {
					alert("输入框不能为空！  ");
				} else {
					$("#tj-addfoodform").submit();
				}
			});

	function tanchuang(id) {
		$("#xg-id").val(id);
		$('#xg-admin').dialog('open');
	}
	
	$("#xg-but").click(
			function() {
				if ($("#foodname1").val().length==0||$("#catelog_id").val().length==0||$("#food_message1").val().length==0||$("#food_price1").val().length==0) {
					alert("信息不能为空")
				} else {
					$("#xg-adminform").submit();
				}
			});
	
	$("#c-but").click(function(){
		location.href="selectfoodbyidaction?id="+$("#queryid").val();
	})
</script>
</html>