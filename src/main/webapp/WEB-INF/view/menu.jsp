<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <link rel="shortcut icon" href="<%=basePath%>images/login.ico">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="<%=basePath%>image/png">
  <link rel="shortcut icon" href="images/login.ico">
  <title>停车收费管理系统</title>
  <!--dashboard calendar-->
  <link href="<%=basePath%>menucss/clndr.css" rel="stylesheet">
  <!--common-->
  <link href="<%=basePath%>menucss/style.css" rel="stylesheet">
  <link href="<%=basePath%>menucss/style-responsive.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <script src="<%=basePath%>js/html5shiv.js"></script>
  <script src="<%=basePath%>js/respond.min.js"></script>
</head>

<body class="sticky-header">
<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">
        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="<%=basePath%>user/index.do"><img src="<%=basePath%>images/logo.png" alt=""></a>
        </div>
        <div class="logo-icon text-center">
            <a href="<%=basePath%>user/index.do"><img src="<%=basePath%>images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->
        <div class="left-side-inner">
            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li class="active">
                	<a href="<%=basePath%>user/index.do"><i class="fa fa-home"></i> <span>我的首页</span></a>
                </li>
                <c:forEach var="mt" items="${menuTypes}">
                	 <li class="menu-list"><a href="">
	                	<i class="${mt.menuTypeIcon}"></i><span>${mt.menuTypeName}</span></a>
	                    <ul class="sub-menu-list">
	                       <c:forEach items="${mt.menus}" var="menu">
	                       		 <li><a href="<%=basePath%>${menu.url}" target="${menu.target}"><i class="fa fa-hand-o-right">&nbsp;&nbsp;${menu.menuName}</i></a></li>
	                       </c:forEach>
	                    </ul>
	                </li>
                </c:forEach>
                <li class="menu-list"><a href="">
	                	<i class="fa fa-cogs"></i><span>我的设置</span></a>
	                    <ul class="sub-menu-list">
	                    	 <li><a href="<%=basePath%>modify.jsp" target="menuFrame"><i class="fa fa-linux"></i><span>修改密码</span></a></li>
	                       	 <li><a href="<%=basePath%>user/exit.do"><i class="fa fa-sign-in"></i><span>退出登录</span></a></li>
            			</ul>
	                </li>
               </ul>
            <!--sidebar nav end-->
        </div>
    </div>
    <!-- left side end-->
    <!-- main content start-->
    <div class="main-content" >
        <!-- header section start-->
        <div class="header-section">
            <!--toggle button start-->
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->
            <!--search start-->
            <form class="searchform" action="<%=basePath%>user/index.do" method="post">
                <input type="text" class="form-control" name="keyword" placeholder="What help!" />
            </form>
            <!--search end-->
            <!--notification menu start -->
            <div class="menu-right">
                <ul class="notification-menu">
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="<%=basePath%>images/photos/avatar.png" alt="" />
                            ${user.userAccount}
                        </a>
                    </li>
                </ul>
            </div>
            <!--notification menu end -->
        </div>
          <div class="row  border-bottom white-bg dashboard-header">
       			 <iframe id="menuFrame" name="menuFrame" src="<%=basePath%>left.html" style="overflow:visible;border:none;padding-left:15px;margin-top: 20px;" scrolling="auto" width="100%;" height="1420px;"></iframe>
          </div>
        <!--body wrapper end-->
    </div>
    <!-- main content end-->
</section>
<!-- Placed js at the end of the document so the pages load faster -->
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="<%=basePath%>js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/modernizr.min.js"></script>
<script src="<%=basePath%>js/jquery.nicescroll.js"></script>
<!--icheck -->
<script src="<%=basePath%>js/icheck-init.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
<!--common scripts for all pages-->
<script src="<%=basePath%>js/scripts.js"></script>
<!--Dashboard Charts-->
<script src="<%=basePath%>js/dashboard-chart-init.js"></script>
</body>
</html>
