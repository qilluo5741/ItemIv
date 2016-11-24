<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
  <head>
    <base href="<%=basePath%>">
    <title>停车管理系统登录</title>
	<meta charset="utf-8">
	<link rel="shortcut icon" href="images/login.ico">
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
 	<link rel="shortcut" href="images/logo.ico">
    <link rel="stylesheet" href="<%=basePath%>css/reset.css">
   	<link rel="stylesheet" href="<%=basePath%>css/supersized.css">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    <script type="text/javascript">
	 	if (window != top){
		top.location.href = location.href;
	}
	</script>
  </head>
  <body>
     <div class="page-container">
            <p><a>停车收费管理系统</a></p>
            <form action="" method="post">
                <input type="text" id="username" name="username" class="username" placeholder="账&nbsp;&nbsp;号"/><br/><br/><br/>
                <input type="password" id="password" name="password" class="password" placeholder="密&nbsp;&nbsp;码"/><br/><br/>
               	<div id="msg" style="font-size:12px;color: red"><br/></div>
                <button type="button" id="login">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
            </form>
        </div>
        <div class="loginbm" style="margin-top:auto;">Company Name &copy;上海享泊信息科技</div>
        <script type="text/javascript" src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
        <script src="<%=basePath%>js/supersized.3.2.7.min.js"></script>
        <script src="<%=basePath%>js/supersized-init.js"></script>
        <script src="<%=basePath%>js/md5.js"></script>
        
        <script type="text/javascript">
        	$(function(){
        		$("#login").click(function(){
        			//得到用户名密码
        			var userName=$("#username").val();
        			var password=$("#password").val();
        			if(userName==""){
        					//验证登录
        					$("#username").css("borderColor","red");
        					$("#username").hide(100);
        					$("#username").show(100);
        				
        			}else if(password==""){
        				//验证登录
        					$("#password").css("borderColor","red");
        					$("#password").hide(100);
        					$("#password").show(100);
        			}
        			else{
        				//执行登录操作前 清空密码框
        				$("#password").val("");
        				$.ajax({
							url:'user/login.do',
							data:{"userName":userName,"userPwd":$.md5(password)},
							type:"post",
							success:function(res){
								  if(res.code=="200"){
									//跳转首页
									window.location.href="user/index.do";
								}else if(res.code=="1001"){
									$("#msg").html("用户名/密码 错误！");
								} 
							},
							error:function(){
								$("#msg").html("后台维护中。。请稍候再试！");
							}
						});
        			}
        		});
        		$("input").keyup(function(){
        			//返回颜色
        			$("#password").css("borderColor","#F0FFFF");
        			$("#username").css("borderColor","#F0FFFF");
        			$("#msg").html("<Br/>");
        		})	
        	})
        </script>
  </body>
</html>
