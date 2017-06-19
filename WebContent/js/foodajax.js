$(document).ready(function() {
	$(".c-tianjia").click(function() {
		$.ajax({
			type: "post",
			url: "selectallcatelognameservlet",
			async: true,
			success: function(date) {
				var json = jQuery.parseJSON(date);
				var list=json[0].list;
				//alert(list);
				console.log(list);
				var str="";
				for(var i in list){
					str+="<option id="+'optionid'+" value="+list[i].id+">"+list[i].catelogname+"</option>";
					console.log(list[i].catelogname);
				}
				$("#food_id").html(str);
			},
			error:function(date){
				alert("错了");
			}
		});
	});
	
	$(".c-taba").click(function(){
		$.ajax({
			type: "post",
			url: "selectallcatelognameservlet",
			async: true,
			success: function(date) {
				var json = jQuery.parseJSON(date);
				var list=json[0].list;
				//alert(list);
				console.log(list);
				var str="";
				for(var i in list){
					str+="<option id="+'optionid1'+" value="+list[i].id+">"+list[i].catelogname+"</option>";
					console.log(list[i].catelogname);
				}
				$("#catelog_id").html(str);
			}
		});
	});
})