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
		<title>公告信息</title>
	</head>

	<body>
		<div class="content">
			<div class="content-headtab">
				<p>公告信息列表
					<span>
				 <a href="#" class="c-tianjia" onclick="javascript:$('#addNoticedialog').dialog('open')">[添加公告]</a>
					<div id="addNoticedialog" class="easyui-dialog" modal="true" closable="false" closed="true" title="添加公告信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="addNoticeform" action="addnoticeaction" method="post">
							<div class="w-index">
								<label class="w-label-1">编号：</label> 
								<input class="w-itext" type="text" id="addNoticeId" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1">公告标题：</label> 
								<input class="w-itext" type="text" id="addNoticeTitle" name="title" placeholder="请输入公告标题" />
							</div>
							<div class="w-index">
								<label class="w-label-1">公告内容：</label>
								<input class="w-itext" type="text" id="addNoticeContent" name="content" placeholder="请输入公告内容" />
							</div>
							<div class="w-index">
								<label class="w-label-1">发布者编号：</label> 
								<input class="w-itext" type="text" id="addNoticeName" name="adminid" placeholder="请输入发布者" />
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input id="addNoticebut" class="w-but1" type="button" value="提交" />
								<input class="w-but1" type="button" onclick="returnAddNotice()" value="返回" />
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
					<form action="selectnoticeidaction" method="post">
						<label class="c-label">编号：</label>
						<input type="text" class="c-text" name="id" value="" placeholder="请输入编号" />
						<input type="submit" class="c-but" value="查询" />
					</form>
				</div>
				<div class="content-tab">
					<table>
						<tr>
							<th width=12%>编号</th>
							<th width=20%>公告标题</th>
							<th width=20%>公告内容</th>
							<th width=12%>发布管理员</th>
							<th width=12%>发布时间</th>
							<th width=12%>修改时间</th>
							<th width=12%>操作</th>
						</tr>
						<c:forEach items="${list}" var="notice">
							<tr>
								<td>${notice.id}</td>
								<td>${notice.title}</td>
								<td>${notice.content}</td>
								<td>${notice.adminid}</td>
								<td>${notice.createtime}</td>
								<td>${notice.updatetime}</td>
								<td>
									<span> 
										<a class="c-taba" href="#" onclick="updateNoticedig('${notice.id}')">修改</a> / 
										<a class="c-taba" onclick="removeNoticedig('${notice.id}')" href="#">删除</a>
									</span>
								</td>
							</tr>
						</c:forEach>
					</table>

					<div id="updateNoticedialog" class="easyui-dialog" modal="true" closable="false" closed="true" title="修改公告信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="updateNoticeform" action="updatenoticeaction" method="post">
							<div class="w-index" style="display: none">
								<label class="w-label-1">编号：</label>
								<input class="w-itext" type="text" id="updateNoticeId" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1">公告标题：</label>
								<input class="w-itext" type="text" id="updateNoticeTitle" name="title" placeholder="请输入公告标题" />
							</div>
							<div class="w-index">
								<label class="w-label-1">公告内容：</label>
								<input class="w-itext" type="text" id="updateNoticeContent" name="content" placeholder="请输入公告内容" />
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input id="updateNoticebut" class="w-but1" type="button" value="提交" />
								<input class="w-but1" type="button" onclick="returnUpdateNotice()" value="返回" />
							</div>
						</form>
					</div>
					<div id="removeNoticedig" class="easyui-dialog" modal="true" closable="false" closed="true" title="删除公告信息" style="width: 400px; background: #fff; overflow: hidden;">
						<form id="removeNoticeform" action="removenoticeaction" method="post">
							<div class="w-index" style="display: none">
								<label class="w-label-1">编号：</label>
								<input class="w-itext" type="text" id="removeNoticeId" name="id" placeholder="请输入编号" />
							</div>
							<div class="w-index">
								<label class="w-label-1" style="width:100%;text-align:left;color:red;font-weight:bold;">是否删除该公告？</label>
							</div>
							<div class="w-index" style="text-align: center; margin-top: 30px;">
								<input class="w-but1" type="submit" value="确认" />
								<input class="w-but1" type="button" onclick="returnNotice()" value="返回" />
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

		$("#addNoticebut").click(function(){
			if($("#addNoticeId").val().length == 0 || $("#addNoticeTitle").val().length == 0 || $("#addNoticeContent").val().length ==0 || $("#addNoticeName").val().length==0){
				alert("信息不能为空！")
			}else{
				$("#addNoticeform").submit();
			}
		});

		function returnAddNotice(){
			$("#addNoticeform").form('clear');
			$("#addNoticedialog").dialog('close');
		}
		
		function updateNoticedig(id){
			$("#updateNoticeId").val(id);
			$("#updateNoticedialog").dialog('open');
		}
		
		$("#updateNoticebut").click(function(){
			if($("#updateNoticeTitle").val().length ==0 || $("#updateNoticeContent").val().length ==0){
				alert("信息不能为空！");
			}else{
				$("#updateNoticeform").submit();
			}
		});
		function returnUpdateNotice(){
			$("#updateNoticeform").form('clear');
			$("#updateNoticedialog").dialog('close');
		}
		function removeNoticedig(id){
			$("#removeNoticeId").val(id);
			$("#removeNoticedig").dialog('open');
		}
		function returnNotice(){
			$("#removeNoticeform").form('clear');
			$("#removeNoticedig").dialog('close');
		}
	</script>
</html>