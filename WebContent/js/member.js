$("document").ready(function(){
	$("#addmember").click(function(){
		$("#win").dialog('open');
	});
	
	$("#returnbutton").click(function(){
		$("#win").dialog('close');
	});
	
	$("#submitbutton").click(function(){
		$("#addmemberform").submit();
	});
	

	$("tr").dblclick(function(){
		$("#resiveid").val($(this).children("#idtext").text());
		$("#usernames").val($(this).children("#usernametext").text());
		$("#passwords").val($(this).children("#passwordtext").text());
		$("input[name='sexs'][value='"+sextext+"'").attr("checked",true);
		$("#realnames").val($(this).children("#realnametext").text());
		$("#tels").val($(this).children("#teltext").text());
		$("#addresss").val($(this).children("#addresstext").text());
		$("#win1").dialog('open');
	});
	
	$("#resivesubmitbutton").click(function(){
		$("#updatememberform").submit();
	});
	
	$("#resivereturn").click(function(){
		$("#win1").dialog('close');
	});
	
	$("#querybutton").click(function(){
		location.href="selectuserbyidservlet?id="+$("#query").val();
	});
})
