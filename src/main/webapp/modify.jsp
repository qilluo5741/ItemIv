<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
  <head>
    <title>停车管理系统修改密码</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO"/>
  	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
  	<meta name="author" content="FREEHTML5.CO" />
	<meta name="twitter:title"/>
	<meta name="twitter:image"/>
	<meta name="twitter:url"/>
	<meta name="twitter:card"/>
	<meta name="description">
    <meta name="author">
	<meta name="renderer" content="webkit" /> 
	<meta name="renderer" content="ie-comp" /> 
	<meta name="renderer" content="ie-stand" />
	<meta name="author" content="FREEHTML5.CO" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body style="background-color:#E0EEE0">
     <div style="margin-top:10xp">
            <p style="font-size:25px;color:#7B68EE">停车后台管理系统密码修改</p>
            <form action="" method="post">
           		<input type="hidden" id="username" name="username" value="${user.userAccount}" class="username"/>
           		<input type="password" id="oldpassword" name="oldpassword" class="oldpassword" placeholder="旧&nbsp;密&nbsp;码"/>
                <input type="password" id="newpassword" name="newpassword" class="newpassword" placeholder="新&nbsp;密&nbsp;码"/><br>
               	<div id="msg" style="font-size: 12px;color: red"><br/></div>
                <button type="button" id="modify">修&nbsp;&nbsp;改&nbsp;&nbsp;密&nbsp;&nbsp;码</button>
            </form>
        </div>
        <script type="text/javascript" src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
        <script src="<%=basePath%>js/md5.js"></script>
        <script type="text/javascript">
        	$(function(){
        		$("#modify").click(function(){
        			//得到用户名密码
        			var userName=$("#username").val();
        			var oldpassword=$("#oldpassword").val();
        			var newpassword=$("#newpassword").val();
        			if(oldpassword==''){
    					//验证原密码
        				alert("请输入原密码");
	    			}else if(newpassword==''){
	    				//验证新密码
	    				alert("请输入新密码");
	    			}else{
	    				$.ajax({
							url:'user/updatemodify.do',
							data:{"userName":userName,"oldpassword":$.md5(oldpassword),"newpassword":$.md5(newpassword)},
							type:"post",
							success:function(res){
								if(res.code=="200"){
									//跳转首页
									alert("修改密码成功！");
									window.location.href="<%=basePath%>user/exit.do";
								}else if(res.code=="2001"){
									$("#oldpassword").val("");
									$("#newpassword").val("");
									$("#msg").html("原密码密码错误！");
								} 
							},
							error:function(){
								$("#msg").html("后台维护中。。请稍候再试！");
							}
						});
        			}
        		});
        	})
        </script>
  </body>
</html>
