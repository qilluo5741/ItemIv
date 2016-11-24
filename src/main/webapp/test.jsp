<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试图片</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
	<script type="text/JavaScript">
	  //定义一个scoket对象
      var websocket = null;
			$(function() {
				var url="ws://192.168.1.118:8080/shareboManager/scoket_server?userId=";
				if ('WebSocket' in window){
					websocket = new WebSocket(url+"zk");
			    }
			    else if ('MozWebSocket' in window){
			    	websocket = new MozWebSocket(url+"zk");
			    }  	
			    else{
			    	alert("浏览器版本过低！请升级..");
			    }
				//连接发生错误的回调方法
				websocket.onerror = function() {
					alert("连接发生错误");
				};
				//连接成功建立的回调方法
				websocket.onopen = function(event) {
					alert("已连接服务器");
				};
				//接收到消息的回调方法
				websocket.onmessage = function(event) {
					$.showMessage(event.data);
				};
				//连接关闭的回调方法
				websocket.onclose = function() {
					alert("已关闭服务器");
				};
				//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
				window.onbeforeunload = function() {
					websocket.close();
				};
				//显示文本
				$.showMessage=function(message){
					 alert(message); 
				}
			})
		</script>
</body>
</html>