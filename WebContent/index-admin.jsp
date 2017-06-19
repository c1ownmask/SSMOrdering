<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="easyui_1.4.4/themes/bootstrap/easyui.css" />
		<link rel="stylesheet" type="text/css" href="easyui_1.4.4/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<script type="text/javascript" src="easyui_1.4.4/jquery.min.js"></script>
		<script type="text/javascript" src="easyui_1.4.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="easyui_1.4.4/jquery.edatagrid.js"></script>
		<script type="text/javascript" src="easyui_1.4.4/locale/easyui-lang-zh_CN.js"></script>
		<script src="js/js.js" type="text/javascript" charset="utf-8"></script>
		<title>管理员列表</title>
	</head>

	<body>
		<div class="content">
			<div class="content-headtab">
				<p>管理员列表
				<span>
				 <a href="#" class="c-tianjia" onclick="javascript:$('#tj-admin').dialog('open')">[添加管理员]</a>
					<div id="tj-admin" class="easyui-dialog" modal="true"closable="false" closed="true" title="添加管理员信息"
						style="width: 400px; background: #fff; overflow: hidden;">
						<form id="tj-adminform" action="addadminaction" method="post">
							<div class="w-index">
								<label class="w-label-1">编号：</label> 
								<input class="w-itext" type="text" id="adminId" name="id" value="" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1">姓名：</label> 
								<input class="w-itext" type="text" id="adminName" name="username" value="" placeholder="请输入姓名" />
							</div>
							<div class="w-index">
								<label class="w-label-1">密码：</label> 
								<input class="w-itext" type="password" id="adminPassword" name="password" value="" placeholder="请输入密码" />
							</div>
							<div class="w-index">
								<label class="w-label-1">确认密码：</label> 
								<input class="w-itext" type="password" id="adminRepassword" name="repassword" value="" placeholder="请再次输入密码" />
							</div>
							<div class="w-index"
								style="text-align: center; margin-top: 30px;">
								<input id="addadminsub" class="w-but1" type="button" value="提交" />
								<input class="w-but1" type="button" onclick="d_close_tj()" value="返回" />
							</div>
						</form>
					</div>
				</span>
				</p>
				<p>
					当前共计<span>0</span>个账户，分为4页 
					<span class="content-tabye">转到： 
						<select class="content-select">
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
						<label class="c-label">关键字：</label> 
						<input type="text" class="c-text" value="" placeholder="请输入关键字" /> <input type="button" class="c-but" value="查询" />
					</form>
				</div>
				<div class="content-tab">
					<table>
						<tr>
							<th width=22%>编号</th>
							<th width=22%>姓名</th>
							<th width=22%>密码</th>
							<th width=22%>创建时间</th>
							<th width=12%>操作</th>
						</tr>
						<c:forEach items="${list}" var="admin">
							<tr>
								<td>${admin.id}</td>
								<td>${admin.adminname }</td>
								<td>${admin.password }</td>
								<td>${admin.create_Time}</td>
								<td><span> <a class="c-taba" href="#"
									onclick="tanchuang('${admin.id}')">修改</a> / <a class="c-taba"
									onclick="remove('${admin.id}')" href="#">删除</a>
							</span></td>
							</tr>
						</c:forEach>
					</table>

					<div id="xg-admin" class="easyui-dialog" modal="true" closable="false" closed="true" title="修改管理员信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="xg-adminform" action="changeadminaction" method="post">
							<div class="w-index" style="display: none">
								<label class="w-label-1">编号：</label> 
								<input class="w-itext" type="text" id="xg-id" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1">姓名：</label> 
								<input class="w-itext" type="text" id="xg-name" name="username" placeholder="请输入姓名" />
							</div>
							<div class="w-index">
								<label class="w-label-1">密码：</label>
								<input class="w-itext" type="password" id="xg-password" name="password" placeholder="请输入密码" />
							</div>
							<div class="w-index">
								<label class="w-label-1">确认密码：</label> 
								<input class="w-itext" type="password" id="xg-repassword" name="repassword" placeholder="请再次输入密码" />
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input id="xg-but" class="w-but1" type="button" value="提交" />
								<input class="w-but1" type="button" onclick="d_close()" value="返回" />
							</div>
						</form>
					</div>
					<div id="remove-admin" class="easyui-dialog" modal="true" closable="false" closed="true" title="删除管理员信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="remove-adminform" action="removeadminaction" method="post">
							<div class="w-index" style="display: none">
								<label class="w-label-1">编号：</label>
								<input class="w-itext" type="text" id="remove-id" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1" style="width:100%;text-align:left;color:red;font-weight:bold;">是否删除该管理员？</label>
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input class="w-but1" type="submit" value="确认" />
								<input class="w-but1" type="button" onclick="remove_close()" value="返回" />
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
			$("#remove-id").val(id);
			$("#remove-admin").dialog('open');
		}

		function remove_close() {
			$("#remove-adminform").form("clear");
			$("#remove-admin").dialog("close");
		}

		function d_close_tj() {
			$("#tj-adminform").form('clear');
			$("#tj-admin").dialog('close');
		}
		
		$("#addadminsub").click(
				function() {
					if($("#adminId").val().length == 0 || $("#adminName").val().length == 0 || $("#adminPassword").val().length == 0 || $("#adminRepassword").val().length == 0 ){
						alert("信息不能为空！");
					}else if($("#adminId").val() != $("#adminName").val()){
						alert("两次密码不同，请重新输入！");
					}else{
						$("#tj-adminform").submit();
					}
		});
		
		function d_close() {
			//清除表单缓存
			$("#xg-adminform").form('clear');
			//关闭窗口
			$("#xg-admin").dialog('close');
		}

		function tanchuang(id) {
			$("#xg-id").val(id);
			$('#xg-admin').dialog('open');
		}
		
		$("#xg-but").click(
			function() {
				if($("#xg-name").val().length == 0 || $("#xg-password").val().length == 0 || $("#xg-repassword").val().length == 0) {
					alert("信息不能为空！");
				} else if($("#xg-password").val() != $("#xg-repassword").val()){
					alert("两次密码不同，请重新输入！");
				}else{
					$("#xg-adminform").submit();
				}
			});
		//查询关键字事件
		$("#querybutton").click(function(){
			
		})
	</script>

</html>