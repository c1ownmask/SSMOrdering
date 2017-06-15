<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<title>会员列表</title>
</head>
<body>
		<div class="content">
			<div class="content-headtab">
				<p>会员列表<span><a href="#" onclick="" class="c-tianjia">[添加会员]</a></span></p>
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
					<form>
						<label class="c-label">关键字：</label>
						<input type="text" class="c-text" value="" placeholder="请输入关键字" />
						<input type="button" class="c-but" value="查询"/>
					</form>
				</div>
				<div class="content-tab">
					<table>
						<tr>
							<th width=10%>编号</th>
							<th width=10%>会员名</th>
							<th width=10%>密码</th>
							<th width=5%>性别</th>
							<th width=5%>姓名</th>
							<th width=10%>联系方式</th>
							<th width=10%>地址</th>
							<th width=10%>创建时间</th>
							<th width=10%>登录时间</th>
							<th width=10%>修改时间</th>
							<th width=10%>编辑</th>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><span><a class="c-taba" onclick="" href="#">修改</a> / <a class="c-taba" onclick="" href="#">删除</a></span></td>
						</tr>
					</table>
				</div>
				<div class="c-foot">
					<p>1/4</p>
				</div>
			</div>
		</div>
	</body>

</html>