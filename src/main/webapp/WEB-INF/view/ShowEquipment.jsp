<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示设备信息</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <style type="text/css">
	   
   </style>
   <script type="text/javascript">
   		$(function(){
   			$(".chickComm").click(function(){
   				if(confirm("确认选择设备：【"+$(this).text()+"】吗？")){
   					alert($(this).attr("id"));
   	   				//跳转
   				}
   			});
   		});
   </script>
  </head>
  <body>
  		<h1 align="center">${msg} </h1>
  		<hr>
		<c:forEach items="${eqs}" var="e">
			<button id="${e.equipmentId }" type="button" class="btn btn-info btn-lg btn-block chickComm">${e.equipmentName }</button>
		</c:forEach>
  </body>
</html>
