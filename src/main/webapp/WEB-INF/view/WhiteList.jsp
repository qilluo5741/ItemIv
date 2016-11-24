<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>白名单</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script>
	  // 现在window.$和window.jQuery是1.83版本:
	      console.log($().jquery); // => '1.8.3'
	      var $jq = jQuery.noConflict(true);
	      // 现在window.$和window.jQuery被恢复成2.1.1版本:
	      console.log($().jquery); // => '2.1.1'
	      // 可以通过$jq访问1.8.3 版本的jQuery了
	</script>
	<script type="text/javascript" src="js/jquery.pagination.js"></script>
	<link rel="stylesheet" href="css/pagination.css" type="text/css"></link>
	<script type="text/javascript">
		//点击分页按钮以后触发的动作
		function handlePaginationClick(new_page_index,pagination_container) {
			$("#supplierForm").attr("action","whiteList/getWhiteList.do?pageIndex="+(new_page_index+1)+"&commId="+$('#ifm',window.parent.document).attr("src").substring(33,50));
			$("#supplierForm").submit();
	    return false;
	}
		$(function(){
  		$("#News-Pagination").pagination(${pager.totalRecords},{
		        items_per_page:${pager.pageSize},//每页显示的数量
		        current_page:${pager.pageIndex}- 1,//当前页数
		        num_display_entries:2,
		        next_text:"下一页",
		        prev_text:"上一页",
		        maxentries:${pager.totalRecords},
		        num_edge_entries:3,//总条目数
		        callback:handlePaginationClick//回调函数
			});
		});
	</script>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
  <script>
   $(function(){  
            $("#periodvalidity").datepicker({//添加日期选择功能  
            /* numberOfMonths:1,//显示几个月  */ 
            showButtonPanel:true,//是否显示按钮面板  
            showOtherMonths: true,
            selectOtherMonths: true,
            showOtherYears:true,
            selectOtherYears:true,
            dateFormat: 'yy-mm-dd',//日期格式  
            clearText:"清除",//清除日期的按钮名称  
            closeText:"关闭",//关闭选择框的按钮名称  
            yearSuffix: '年', //年的后缀  
            showMonthAfterYear:true,//是否把月放在年的后面  
            /*defaultDate:'2011-03-10',//默认日期 */ 
           /* minDate:'2011-03-05',//最小日期  
            maxDate:'2011-03-20',//最大日期  */
            monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],  
            dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
            dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
            dayNamesMin: ['日','一','二','三','四','五','六'],  
           /* onSelect: function(selectedDate) {//选择日期后执行的操作  
                alert(selectedDate);  
            }  */
            });
        });  
</script>
</head>
<body>
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column" id="con">
		<form role="form" class="form-inline">
				<div class="form-group" align="left">
					 <label for="exampleInputEmail1">车主姓名:<input type="text" class="form-control" id="ssName" value="${name}" width="120px;" placeholder="请输入名字查询！"></label>
					 <label for="exampleInputPassword1">车牌号:<input type="text" class="form-control" id="ssCarNo" value="${carNo}" width="120px;" placeholder="请输入车牌查询！"></label>
					 <label for="exampleInputPassword1">车主住址:<input type="text" class="form-control" id="ssAddress" value="${address}" width="120px;" placeholder="请输入住址查询！"></label>
					 <label><input type="button" class="btn btn-default" id="search" value="搜索"></label>
					 <label><input type="button" class="btn btn-default" id="new" value="新建"></label>
				</div>
			</form>
			<div class="progress"><div class="progress-bar progress-success"></div></div>
			<c:if test="${empty pager}">
		 			<c:redirect url="whiteList/getWhiteList.do"></c:redirect>
             </c:if> 
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
					    <th>车主</th>
						<th>车辆</th>
						<th>手机号码</th>
						<th>停车场</th>
						<th>车主地址</th>
						<th>到期时间</th>
						<th>支付类型</th>
						<th>是否失效</th>
						<th>操作</th>
						<th>修改有效期</th>
					</tr>
				</thead>
				<c:forEach items="${pager.list}" var="p">
				<tr>
				<td>${p.name}</td>
				<td>${p.carNo}</td>
				<td>${p.phone}</td>
				<td>${p.cname}</td>
				<td>${p.address}</td>
				<td>${p.periodvalidity}</td>
				<td>
				   <c:choose>
				     <c:when test="${p.chargeTimeType==0}">月付</c:when>
				     <c:when test="${p.chargeTimeType==1}">季付</c:when>
				     <c:when test="${p.chargeTimeType==2}">半年付</c:when>
				     <c:when test="${p.chargeTimeType==3}">年付</c:when>
				   </c:choose>
				</td>
				<td>
				<c:choose>
				   <c:when test="${p.isDisable==0}">
				      <span style="color: red">已失效</span>
				   </c:when>
				   <c:when test="${p.isDisable==1}">
				     <span style="color: green">未失效</span>
				   </c:when>
				</c:choose>
				</td>
				<td style="text-align: center"><button type="button" class="btn btn-default delete" id="${p.whitelistId}" style="background-color: #FF8C69">删除</button></td>
				<td>
				<button type="button" class="btn btn-default update" id="${p.whitelistId}" data-toggle="modal" data-target="#myModal" style="background-color: #00FA9A">修改</button>
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									请选择新的白名单有效期
								</h4>
							</div>
							<div class="modal-body">
							<label for="periodvalidity">白名单有效期:</label>
								<input type="text" style="width: 100%" class="form-control" id="periodvalidity" placeholder="请选择新的白名单有效期">
								<b>支付类型：</b>
					 	 <select class="chargeTimeType" style="text-align: center;font-size:13px;width: 30%;height:35px;border: 1px solid #CDC28D;">
						    	          <option value="0" selected="selected">月付</option>
								         <option value="1">季付</option>
								         <option value="2">半年付</option>
								         <option value="3">年付</option>
						 </select>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="button" class="btn btn-primary updateisfailure" id="exchange" name="">
									提交更改
								</button>
							</div>
						</div>
					</div>
				</div>
				</td>
				</tr>
				</c:forEach>
				<!-- <tr>
			    	<td colspan="8" align="left" style="height:auto;">
				  		<form id="returnForm" method="post"></form>
				 		 <div>
					  		<div style="" id="News-Pagination"  align="left"></div>
						</div>
					</td>
				</tr>  -->
				</table>
				<form id="supplierForm"  method="post" action="">
		<div style="height:20px;" id="News-Pagination"  align="center"></div>
	</form>
			</div>
		</div>
		<input type="button" class="btn btn-default" name="Submit" value="返回上一页" onclick="javascript:window.history.back(-1);">
	</div>
	<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var whitelistId=$(this).attr("id");
			if(confirm("您确定要删除吗?")){
				$.ajax({
				url:'whiteList/deleteWhiteList.do',
				data:{"whitelistId":whitelistId},
				type:'post',
				success:function(res){
					if(res.code=="200"){
						alert("删除成功");
						location.reload();
					}
					else{
						alert(res.message);
						location.reload();
					}
				}
			});
			}
		});
	});
	</script>
	<script type="text/javascript">
	$(function(){
		 $("#con").find("#new").click(function(){
			 var commId=$('#ifm',window.parent.document).attr("src").substring(33,50);
			 if(commId==null||commId==""){
				 alert("请选择相应的停车场进行添加白名单");
			 }
			 else{
			 $('#ifm',window.parent.document).attr("src","CreateWhiteList.jsp");
			 $('#ifm',window.parent.document).attr("name",commId);
			 }
		  });
	});
	</script>
	<script type="text/javascript">
	$(function(){
		$("#con").find("#search").click(function(){
			 var commId=$(' #ifm',window.parent.document).attr("src").substring(33,50);
			 var name=$("#ssName").val();
			 var carNo=$("#ssCarNo").val();
			 var address=$("#ssAddress").val();
			 if(name==null){
				 name="";
			 }
			 if(carNo==null){
				 carNo="";
			 }
			 if(address==null){
				 address="";
			 }
			 $('#ifm',window.parent.document).attr("src","whiteList/getWhiteList.do?commId="+commId+"&name="+name+"&carNo="+carNo+"&address="+address);
		 });
	 });
	</script>
	<script type="text/javascript">
	   $(function(){
		   $(".update").click(function(){
			   $(".updateisfailure").attr("name",$(this).attr("id"));
		   });
	   });
	</script>
	<!-- 修改白名单有效期 -->
	<script type="text/javascript">
	   $(function(){
		   $(".updateisfailure").click(function(){
			   var whitelistId=$(this).attr("name"); 
			   var time=$("#periodvalidity").val();
			   var periodvalidity=time.substring(0,4)+time.substring(5,7)+time.substring(8,10);
			   var chargeTimeType=$(".chargeTimeType").val();
			   $.ajax({
				   url:'whiteList/updateisfailure.do',
				   data:{"whitelistId":whitelistId,"periodvalidity":periodvalidity,"chargeTimeType":chargeTimeType},
				   type:'post',
				   success:function(res){
					   if(res.code=="200"){
						   alert(res.message);
						   location.reload();
					   }
					   else{
						   alert(res.message);
						   location.reload();
					   }
				   }
			   });
		   });
	   });
	</script>
</body>
</html>