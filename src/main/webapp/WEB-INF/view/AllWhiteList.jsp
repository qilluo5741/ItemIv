<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
<title>全部白名单</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/index/jquery.min.js"></script>
<link href="css/custom.css" rel="stylesheet">
<script src="js/index/metisMenu.min.js"></script>
<script src="js/index/custom.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body style="background-color:#E5E5E5;">
	<div class="navbar-default sidebar" id="test">
		  <div class="sidebar-nav navbar-collapse"  style="margin-top:-30px;">                 
		     <span class="fa fa-laptop nav_icon" style="color: #FFD700;font-size: 24px;margin-bottom:10px">全部停车场</span>
		     <div><span style="text-align:left;margin-bottom:10px;color: #FF8C69;font-family: 华文细黑">请选择您所管辖的停车场</span></div><br>
			 <ul class="nav nav-second-level">
				<c:forEach items="${pager}" var="p">
			          <li style="text-align:left;margin-bottom:10px;"><a class="comm" href="javascript:void;" id="${p.commVal}"><i class="fa fa-hand-o-right" style="color:#1F1F1F;letter-spacing:1px;font-size:21px;">&nbsp;&nbsp;${p.commName}</i></a></li>
			     </c:forEach>
			</ul>
		</div>
	</div>
	<div id="page-wrapper" class="ifame">
		<iframe src="left.html" height="660" frameborder="0" marginheight="0" marginwidth="0" frameborder="0" scrolling="auto" id="ifm" name="ifm"  width="100%"></iframe>
	</div>
</body>
	<script type="text/javascript">
	  $(function(){
		  $('.comm').click(function(){
			  //alert($(this).attr("id"));
			  $('#ifm').attr("src","whiteList/getWhiteList.do?commId="+$(this).attr("id"));
		  }); 
	  });
	</script>
</html>