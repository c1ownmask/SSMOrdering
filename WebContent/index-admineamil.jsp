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
		<title>管理员邮箱</title>
	</head>

	<body>
	<div class="content">
			<div class="content-headtab">
				<p>管理员邮箱列表
					<span></span>
				</p>
				<p>当前共计<span>0</span>个账户，分为4页
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
				</div>
				<div class="content-tab">
					<table>
						<tr>
							<th width=22%>编号</th>
							<th width=32%>信件内容</th>
							<th width=17%>发送时间</th>
							<th width=17%>发件人</th>
							<th width=12%>操作</th>
						</tr>
						<c:forEach items="${list}" var="eamil">
							<tr>
								<td>${eamil.id}</td>
								<td>${eamil.content}</td>
								<td>${eamil.time}</td>
								<td>${eamil.userid}</td>
								<td>
									<span>
										<a class="c-taba" onclick="remove_eamil('${eamil.id}')" href="#">删除</a>
									</span>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div id="remove-admineamil" class="easyui-dialog" modal="true" closable="false" closed="true" title="删除管理员信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="remove-admineamilform" action="removeeamilaction" method="post">
							<div class="w-index" style="display: none">
								<label class="w-label-1">编号：</label>
								<input class="w-itext" type="text" id="remove-eamilid" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1" style="width:100%;text-align:left;color:red;font-weight:bold;">是否删除该信息？</label>
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input class="w-but1" type="submit" value="确认" />
								<input class="w-but1" type="button" onclick="remove_eclose()" value="返回" />
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
		function remove_eamil(id){
			$("#remove-eamilid").val(id);
			$("#remove-admineamil").dialog('open');
		}
		function remove_eclose(){
			$("#remove-admineamilform").form('clear');
			$("#remove-admineamil").dialog('close');
		}
	</script>
	
</html>