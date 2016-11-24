<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>入场</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body  >
  		<h3 align="center">收费</h3>
		<div align="center">应收费用：<b><span style="color: red;font-size: 35px;">50.0</span></b>元</div>
		<hr>
		<div class="form-group" align="center" >
		   <label for="name" >实际收费</label>
		    <input style="width: 30%;font-style: italic;" type="text" class="form-control" id="name" value="50.0" placeholder="实际收费">
		    <select class="carType" style="text-align: center;font-size:13px;width: 30%;height:40px;border: 1px solid #CDC28D;">
					          <option value="0" selected="selected">外来车辆</option>
					         <option value="1">物业车辆</option>
					         <option value="2">军用车辆</option>
					         <option value="3">其他车辆</option>
			 </select>
			 <hr>
		     <button type="button" class="btn btn-primary btn-lg btn-block">确认收费</button>
		 </div>
  </body>
</html>
