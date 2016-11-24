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
	<script type="text/JavaScript">
		$(function() {
			Cookie.set("zhu","章科")
			
			$("#getCarNo").click(function() {
				var varNo = "";
				//获取车牌号码
				$(".inp").each(function(i, n) {
					varNo += $(n).val();
				});
				alert(varNo);
			});
			//回删光标跳转
			$(".inp").keyup(
					function(e) {
						if (e.keyCode == 8) {//退格事件
							//吧光标移至在上一个兄弟节点上去
							$(this).val("");
							$(this).prev().focus();
						}
						if ((e.keyCode >= 48 && e.keyCode <= 57)
								|| (e.keyCode >= 65 && e.keyCode <= 90)
								|| (e.keyCode >= 96 && e.keyCode <= 105)) {//输入的数字 和字母
							$(this).next().focus();
						}
					});
			$(".inp").change(function() {
				//截取最后一位
				var val = $(this).val();
				$(this).val(val.substring(val.length - 1, val.length));
			});
		});
	</script>
	<div id="inpId">
		<input type="text" class="inp" style="width: 40px;"> <input
			type="text" class="inp" style="width: 40px;"> <input
			type="text" class="inp" style="width: 40px;"> <input
			type="text" class="inp" style="width: 40px;"> <input
			type="text" class="inp" style="width: 40px;"> <input
			type="text" class="inp" style="width: 40px;">
	</div>

	<input type="button" id="getCarNo">

</body>

</html>