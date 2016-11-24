<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
  <base href="<%=basePath%>">
    <title>单个停车信息管理</title>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/pagination.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery.pagination.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
	<!--common-->
    <script type="text/javascript">
	function handlePaginationClick(new_page_index,pagination_container) {
	    $("#supplierForm").attr("action","harmon/getHarmonioulist.do?pageIndex="+(new_page_index+1));
	    $("#supplierForm").submit();
	    return false;
	}
  	$(function(){
			$("#News-Pagination").pagination(${pager.totalRecords},{
		        items_per_page:${pager.pageSize},
		        current_page:${pager.pageIndex}- 1,
		        num_display_entries:2,
		        next_text:"下一页",
		        prev_text:"上一页",
		        maxentries:${pager.totalRecords},
		        num_edge_entries:3,
		        callback:handlePaginationClick
			});
		});
  	</script>
  </head>
  <body>
  	<div align="right"><a href="javascript:void(0)"><button class="alet" style="border-bottom-style:none;">导出EXcel</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <table class="table table-striped">
    		   <thead>
		      <tr style="background-color:#C9F136">
		         <th>序号</th>
		         <th>订单号</th>
		         <th>进时间</th>
		         <th>出时间</th>
		         <th>停留时间</th>
		         <th>车牌号</th>
		         <th>白名单用户</th>
		         <th>缴费有效期</th>
		         <th>临停收费标准</th>
		         <th>应收费用</th>
		      </tr>
		   </thead> 
		   <tbody>
		    	<c:forEach  items="${pager.list}" var="p">
		    		  <tr>
				         <td>${p.harmonid}</td>
				         <td>${fn:substring(p.ordernumber,4,24)}</td>
						 <td>${fn:substring(p.approachtime,0,15)}</td>
						 <td>${fn:substring(p.playingtime,0,15)}</td>
				         <td>${p.minutes}分钟</td>
				         <td>${p.platenumber}</td>
				         <td align="center">
				        	<c:choose>
								<c:when test="${p.whiteuser == 1}">
									是
								</c:when>
								<c:when test="${p.whiteuser == 2}">
									否
								</c:when>
							</c:choose>
				         </td>
				         <td>${fn:substring(p.paymentperiod,0,15)}</td>
				         <td>
				         <c:choose>
								<c:when test="${p.standard == 1}">
									10元/次
								</c:when>
								<c:when test="${p.standard == 2}">
									5元/小时
								</c:when>
							</c:choose>
				         </td>
				         <td>${p.receivable}元</td>
				      </tr>
		    	 </c:forEach>
	   	   </tbody>
	</table>
	<form id="supplierForm"  method="post" action="">
		<div style="height:20px;" id="News-Pagination"  align="center"></div>
	</form>
	<script type="text/javascript">
	$(function(){
		$(".alet").click(function(){
				alert("正在处于维护中...请稍后再来试试！");
			})
		});
	</script>
</html>
