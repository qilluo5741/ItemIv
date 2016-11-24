<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试图片</title>
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="<%=basePath%>js/cookie_util.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			
			//添加cookie
			//Cookie.set("zhu", "章科", null, 120);
			//删除cookie
			//读取cookie
			//alert(Cookie.get("zhu"));
			
			/* function carinfo(vid, name) {
				this.vid=vid;
				this.name=name;
				return this;
			}
			ary.push(carinfo('1','张三'));
			
			alert(ary[0].name); */
			
		/* 	while(true){
				var val=Cookie.get("zhu");
				if(val!=null){
					alert(val);
					Cookie.del("zhu")
					break;
				}
				
			} */
			
		 /*  var timeTask=setInterval(function(){
		        var date=new Date();
		        var h=date.getHours();
		        var m=date.getMinutes();
		        var s=date.getSeconds();
		             callFunction();
		    },1000);//一秒
		    function callFunction(){
		    	var val=Cookie.get("zhu");
		    	if(val!=null){
					alert(val);
					Cookie.del("zhu")
				}
		    }  */ 
		});
	</script>
</body>

</html>