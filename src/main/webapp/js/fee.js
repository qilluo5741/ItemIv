var websocket_in = null;
var websocket_out = null;
$(function(){
	//加载全部设备
	////刷新页面window.location.reload(); 
	$.ajax({
		url:'fee/ShowEquipment_result.do',
		type:"post",
		dataType:"json",
		success:function(res){
			//遍历入场设备
			$.each(res.eqsIn,function(index,element){
				var $carIn_eq_btn=$("#carIn_eq_btn");
				$carIn_eq_btn.append("<button id='"+element.equipmentNumber+"' comm='"+element.commId+"' type='button' class='btn btn-info btn-lg btn-block chickCommIn' onClick='javascript:$.chickComm_In(this)'> "+element.equipmentName+"</button>");
			});
			//遍历出场设备
			$.each(res.eqsOut,function(index,element){
				var $carOut_eq_btn=$("#carOut_eq_btn");
				$carOut_eq_btn.append("<button id='"+element.equipmentNumber+"' comm='"+element.commId+"' type='button' class='btn btn-info btn-lg btn-block chickCommIn' onClick='javascript:$.chickComm_Out(this)'> "+element.equipmentName+"</button>");
			}); 
		},
		error:function(){
			alert("登陆超时，请重新登陆后进行刷新！");
		}
	});
	//scoket链接
	$.chickComm_Out=function(val){
		//修改页面数据
		$("#carOut_eq_btn").text("正在连接中。。。");
		//$(val).attr("id")
		//创建连接scoket
		var url="ws://"+$("#baseurl").val()+"/scoket_server";
		var str="?eqNo="+$(val).attr("id")+"&commId="+$(val).attr("comm");
		if ('WebSocket' in window){
			websocket_out = new WebSocket(url+str);
		}
		else if ('MozWebSocket' in window){
			websocket_out = new MozWebSocket(url+str);
		}  	
		else{
			alert("浏览器版本过低！请升级..");
		}
		//连接发生错误的回调方法
		websocket_out.onerror = function() {
			//alert("连接发生错误");
			$("#carOut_eq_btn").text("连接发生错误..请重新连接");
		};
		//连接成功建立的回调方法
		websocket_out.onopen = function(event) {
			//alert("已连接服务器");
			$("#carOut_eq").hide();
			$("#carOut_carimg").show();
		};
		//接收到消息的回调方法
		websocket_out.onmessage = function(event) {
			$.showMessage_out(event.data);
		};
		//连接关闭的回调方法
		websocket_out.onclose = function() {
			//alert("已关闭服务器");
			$("#carOut_eq_btn").text("已关闭服务器");
		};
		//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
		window.onbeforeunload = function() {
			websocket_out.close();
		};
		//显示文本
		$.showMessage_out=function(message){
			var data = $.parseJSON(message);
			
			$("#out_carNo").text(data.carNo);
			//添加收费信息
			$("#yfee").text(data.money);
			$("#sfee").val(data.money);
			$("#carNo_Fee").html(data.carNo);
			$("#out_carFrom").text(data.carFrom);
			$("#showCarInfoAndCommInfo").html(data.feeInstructions);
			$("#valCharge").attr("name",data.vehicleId);
			//显示图片
			$("#out_bigImg").attr("src",data.bigImg);
			//添加记录数据
			var $oldCarInfo=$("#oldCarInfo");
			$oldCarInfo.prepend("<tr><td>"+data.carNo+"</td><td>"+data.date+"</td><td>出</td><td>"+data.money+"</td><td></td></tr>");
			//自动删除20条以后的数据
			$(".carInfo").children().eq(2).children().eq(20).remove();
		}
	}
	//scoket进入链接
	$.chickComm_In=function(val){
		//修改页面数据
		$("#carIn_eq_btn").text("正在连接中。。。");
		//$(val).attr("id")
		//创建连接scoket
		var url="ws://"+$("#baseurl").val()+"/scoket_server";
		var str="?eqNo="+$(val).attr("id")+"&commId="+$(val).attr("comm");
		if ('WebSocket' in window){
			websocket_in = new WebSocket(url+str);
		}
		else if ('MozWebSocket' in window){
			websocket_in = new MozWebSocket(url+str);
		}  	
		else{
			alert("浏览器版本过低！请升级..");
		}
		//连接发生错误的回调方法
		websocket_in.onerror = function() {
			//alert("连接发生错误");
			$("#carIn_eq_btn").text("连接发生错误..请重新连接");
		};
		//连接成功建立的回调方法
		websocket_in.onopen = function(event) {
			//alert("已连接服务器");
			$("#carIn_eq").hide();
			$("#carIn_carimg").show();
		};
		//接收到消息的回调方法
		websocket_in.onmessage = function(event) {
			$.showMessage(event.data);
		};
		//连接关闭的回调方法
		websocket_in.onclose = function() {
			//alert("已关闭服务器");
			$("#carIn_eq_btn").text("已关闭服务器");
		};
		//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
		window.onbeforeunload = function() {
			websocket_in.close();
		};
		//显示文本
		$.showMessage=function(message){
			var data = $.parseJSON(message);
			$("#in_carNo").text(data.carNo);
			$("#feeInstructions").html(data.feeInstructions);
			$("#in_carFrom").text(data.carFrom);
			//显示图片
			$("#in_bigImg").attr("src",data.bigImg);
			//添加记录数据
			var $oldCarInfo=$("#oldCarInfo");
			$oldCarInfo.prepend("<tr><td>"+data.carNo+"</td><td>"+data.date+"</td><td>进</td><td></td><td>" +
					"<button type='button' class='btn btn-warning btn-xs updateCarNo' id='"+data.vehicleId+"' data-toggle='modal' data-target='#myModal'>修改</button></td></tr>");
			//自动删除20条以后的数据
			$(".carInfo").children().eq(2).children().eq(20).remove();
		}
	}
});


	
	
