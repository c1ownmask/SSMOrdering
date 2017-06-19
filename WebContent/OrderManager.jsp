<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
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
</head>
<body>
	<div class="content">
		<div class="content-headtab"></div>
		<div class="content-foot">
			<div class="content-tab">
				<table>
					<tr>
						<th>编号</th>
						<th>价格</th>
						<th>状态</th>
						<th>创建时间</th>
						<th>会员</th>
						<th>操作</th>
					</tr>
					<c:forEach var="list" items="${list}">
						<tr>
							<td>${list.id}</td>
							<td>${list.prices}</td>
							<td>${list.status}</td>
							<td>${list.createtime}</td>
							<td>${list.userid}</td>
							<td><a class="c-taba" href="#"
									onclick="shanchu('${list.id}')">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function shanchu(id) {
		$.ajax({
			type:"post",
			url:"deleteorderaction?id="+id,
			async:true,
			success:function(data){
				var json=jQuery.parseJSON(data);
				var message=json[0].message;
				if(message){
					alert("删除成功!");
					location.href="selectallorderaction";
				}
			},
			error:function(data){
				alert(data);
			}
		});
	};
</script>
</html>