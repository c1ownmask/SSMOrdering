<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
<link rel="stylesheet" type="text/css"
	href="easyui_1.4.4/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="easyui_1.4.4/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="easyui_1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="easyui_1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui_1.4.4/jquery.edatagrid.js"></script>
<script type="text/javascript"
	src="easyui_1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/member.js"></script>

</head>
<body>
	<div class="content">
		<div class="content-headtab">
			<p>
				会员列表 <span> <a id="addmember" class="c-tianjia">[添加会员]</a>
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

				<label class="c-label">关键字：</label> <input type="text"
					class="c-text" value="" placeholder="请输入关键字" /> <input
					type="button" class="c-but" value="查询" />

			</div>
			<div class="content-tab">
				<table>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>真实姓名</th>
						<th>联系方式</th>
						<th>地址</th>
						<th>创建时间</th>
						<th>登陆时间</th>
						<th>修改时间</th>
						<th>编辑</th>
					</tr>
					<c:forEach items="${list}" var="user">
						<tr>
							<td id="idtext">${user.id}</td>
							<td id="usernametext" class="usernametext">${user.username }</td>
							<td id="passwordtext">${user.password }</td>
							<td id="sextext">${user.sex }</td>
							<td id="realnametext">${user.realname }</td>
							<td id="teltext">${user.tel }</td>
							<td id="addresstext">${user.address }</td>
							<td style="font-size: 8px;">${user.createtime }</td>
							<td style="font-size: 10px;">${user.logintime }</td>
							<td style="font-size: 10px;">${user.updatetime }</td>
							<td><span><a class="c-taba" 
									href="deleteuseraction?id=${user.id}">删除</a> </span></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="c-foot">
				<p>1/1</p>
			</div>
		</div>
		<div id="win" class="easyui-dialog" title="添加会员信息" closed="true" modal="true"
			close="true"
			style="width: 400px; height: 300px; background: #fff; overflow: hidden;z-index: 3">
			<form action="addmemberaction" method="post" id="addmemberform">
				<table style="margin: auto; line-height: 30px;">
					<tr>
						<td><label>姓名：</label></td>
						<td><input type="text" id="username" name="username"
							placeholder="请输入姓名" /></td>
					</tr>
					<tr>
						<td><label>密码：</label></td>
						<td><input type="password" id="password" name="password"
							placeholder="请输入密码" /></td>
					</tr>
					<tr>
						<td><label>性别：</label></td>
						<td><input type="radio" name="sex" id="sex" value="男"
							checked="checked" />男 &nbsp;&nbsp;<input type="radio" name="sex"
							id="sex" value="女" />女</td>
					</tr>
					<tr>
						<td><label>真实姓名：</label></td>
						<td><input type="text" id="realname" name="realname"
							placeholder="请输入真实姓名" /></td>
					</tr>
					<tr>
						<td><label>联系方式：</label></td>
						<td><input type="text" id="tel" name="tel"
							placeholder="请输入联系方式" /></td>
					</tr>
					<tr>
						<td><label>地址：</label></td>
						<td><input type="text" id="address" name="address"
							placeholder="请输入地址" /></td>
					</tr>
				</table>
			</form>
			<div class="w-index" style="text-align: center; margin-top: 20px;">
				<input class="w-but1" type="button" id="submitbutton" value="提交" />
				<input id="returnbutton" class="w-but1" type="button" value="返回" />
			</div>
		</div>
		<div id="win1" class="easyui-dialog" title="修改会员信息" closed="true" modal="true"
			close="true"
			style="width: 400px; height: 300px; background: #fff; overflow: hidden;z-index: 3">
			<form action="updatememberaction" method="post" id="updatememberform">
				<input type="text" id="resiveid" name="resiveid" style="display: none"/>
				<table style="margin: auto; line-height: 30px;">
					<tr>
						<td><label>姓名：</label></td>
						<td><input type="text" id="usernames" name="usernames"
							value="" placeholder="请输入姓名" /></td>
					</tr>
					<tr>
						<td><label>密码：</label></td>
						<td><input type="password" id="passwords" name="passwords"
							value="" placeholder="请输入密码" /></td>
					</tr>
					<tr>
						<td><label>性别：</label></td>
						<td><input type="radio" name="sexs" id="sexs" value="男" />男
							&nbsp;&nbsp;<input type="radio" name="sexs" id="sexs" value="女" />女</td>
					</tr>
					<tr>
						<td><label>真实姓名：</label></td>
						<td><input type="text" id="realnames" name="realnames"
							placeholder="请输入真实姓名" /></td>
					</tr>
					<tr>
						<td><label>联系方式：</label></td>
						<td><input type="text" id="tels" name="tels"
							placeholder="请输入联系方式" /></td>
					</tr>
					<tr>
						<td><label>地址：</label></td>
						<td><input type="text" id="addresss" name="addresss"
							placeholder="请输入地址" /></td>
					</tr>
				</table>
			</form>
			<div class="w-index" style="text-align: center; margin-top: 20px;">
				<input class="w-but1" type="button" id="resivesubmitbutton"
					value="提交" /> <input id="resivereturn" class="w-but1"
					type="button" value="返回" />
			</div>
		</div>
	</div>
</body>
</html>