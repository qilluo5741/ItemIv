<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <title>设备管理</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script> -->
</head>
<body>
<table class="table table-bordered" style="text-align: center;">
	<caption style="text-align:center;font-size:30px">设备管理</caption>
	<thead>
		<tr>
			<!-- <th style="text-align: center;">设备号</th> -->
			<th style="text-align: center;">停车场名字</th>
			<th style="text-align: center;">设备名字</th>
			<!-- <th style="text-align: center;">设备等级</th> -->
			<th style="text-align: center;">是否出口</th>
			<th style="text-align: center;">管理</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${pager}" var="p">
		<tr>
			<%-- <td id="equipmentNumber">${p.equipmentNumber}</td> --%>
			<td>
				<span>${p.cname}</span>
			</td>
			<td><span>${p.equipmentName}</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-default updateEquipName" id="${p.equipmentNumber}" data-toggle="modal" data-target="#myModal" style="background-color: #00FA9A">修改</button>
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									请输入新的设备名字
								</h4>
							</div>
							<div class="modal-body">
								<input type="text" style="width:100%" class="form-control" id="newCname">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="button" class="btn btn-primary exchange" id="exchange" name="">
									提交更改
								</button>
							</div>
						</div>
					</div>
				</div>
			</td>
			<%-- <td>${p.commparent}</td> --%>
			<td>
			<c:choose>
			<c:when test="${p.isinout == 1}">
			    <span>入口</span>
			</c:when>
			<c:when test="${p.isinout == 2}">
			    <span>出口</span>
			</c:when>
			</c:choose>
			</td>
			<td style="text-align: left;padding-left: 35px">
			<c:choose>
			<c:when test="${p.isinout == 1}"><!-- 入口 -->
			    <button type="button" class="btn btn-default btn-sm" id="restart" disabled="disabled" style="background: #87CEEB">重启</button>
			    &nbsp;&nbsp;
			    <button type="button" class="btn btn-default btn-sm" id="statement" disabled="disabled" style="background-color: #87CEFA">状态</button>
			</c:when>
			<c:when test="${p.isinout == 2 and p.isTollBooths==1}"><!--出口 且是收费亭-->
			    <button type="button" class="btn btn-default btn-sm" id="restart" disabled="disabled" style="background: #87CEEB">重启</button>
			    &nbsp;&nbsp;
			    <button type="button" class="btn btn-default btn-sm" id="statement" disabled="disabled" style="background-color: #87CEFA">状态</button>
			    <button type="button" class="btn btn-default updateIsTollbooths" id="${p.equipmentNumber}" style="background-color: #F5F5F5">取消设置收费亭</button>
			   <!--  &nbsp;&nbsp;
			    <button type='button' class='btn btn-default btn-sm' id='setCashier'>设置收费员</button> -->
			</c:when>
			<c:when test="${p.isinout == 2 and p.isTollBooths==0}"><!-- 出口 不是收费亭 -->
			<button type="button" class="btn btn-default btn-sm" id="restart" disabled="disabled" style="background: #87CEEB">重启</button>
			    &nbsp;&nbsp;
			    <button type="button" class="btn btn-default btn-sm" id="statement" disabled="disabled" style="background-color: #87CEFA">状态</button>
			    <button type="button" class="btn btn-default btn-sm setTollBooths" id="${p.equipmentNumber}" style="background-color: #EEDC82">设置收费亭</button>
			    </c:when>
			</c:choose>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
  $(function(){
	  $(".updateEquipName").click(function(){
		  $(".exchange").attr("name",$(this).attr("id"));
		  $("#newCname").val($(this).prev().text());
	  });
  });
</script>
<script type="text/javascript">
   $(function(){
	   $(".exchange").click(function(){
		    var newCname=$("#newCname").val();
			var equipmentNumber=$(this).attr("name");
			$.ajax({
				url:'equipment/updateEquipmentName.do',
				data:{"equipmentNumber":equipmentNumber,"equipmentName":newCname},
				type:"post",
				success:function(res){
					if(res.code=="200"){
						alert(res.message);
						location.reload();
					}else{
						alert(res.message);
					}
				},error:function(){
					location.reload();
				}
            });
	   });
   });
</script>
<!-- 取消设置收费亭 -->
<script type="text/javascript">
   $(function(){
	   $(".updateIsTollbooths").click(function(){
		   var equipmentNumber=$(this).attr("id");
		   $.ajax({
			   url:'equipment/updateIsTollBooths.do',
			   data:{"equipmentNumber":equipmentNumber,"isTollBooths":0},
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
<!-- 设置收费亭 -->
<script type="text/javascript">
   $(function(){
	   $(".setTollBooths").click(function(){
		   var equipmentNumber=$(this).attr("id");
		   $.ajax({
			   url:'equipment/updateIsTollBooths.do',
			   data:{"equipmentNumber":equipmentNumber,"isTollBooths":1},
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