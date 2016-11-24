<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.printf(request.getRemoteAddr()+"   1");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收费系统</title>
    <link rel="shortcut icon" href="images/login.ico">
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <!-- 引入js -->
   <script type="text/javascript" src="<%=basePath%>js/fee.js"></script>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <style type="text/css">
   	.show_{
   		border:1px solid green;
   		width: 49%;
   		height: 50%;
   		float: left;
   	}
   </style>
  </head>
  <body>
		<div>
			<input type="hidden" id="baseurl" value="<%=request.getHeader("Host")%>">
			<!-- 显示入场数据 -->
			<div class="show_">
				<div id="carIn_eq">
					<div align="center">选择入场设备</div>
					<div id="carIn_eq_btn">
						
					</div>
				</div>
				<div id="carIn_carimg" style="display: none;">
					<h3 align="center">入场图片</h3>
					<div align="center" style="width: 100%">
						<div  style="width: 50%;height: 70%;float: left;">
							<img id="in_bigImg" alt="入场" src="<%=basePath%>images/1.jpg" width="100%" height="100%">
						</div>
					</div>
					<div align="center">
						<span> 
							<b>车牌号：</b>
						</span>
						<b><span id="in_carNo" style="font-size: 35px;color: blue;"></span></b>
						<hr>
						<span>
							<b>车辆来源：</b>
						</span>
						<b><span id="in_carFrom" style="font-size: 35px;color: blue;"></span></b>
					</div>
				</div>
			</div>
			<!-- 显示出场数据 -->
			<div class="show_"><!-- ----------------------begin------------------------------------------- -->
				<div id="carOut_eq">
					<div align="center">选择出场设备</div>
					<div id="carOut_eq_btn">
						
					</div>
				</div>
				<div id="carOut_carimg" style="display: none;">
					<h3 align="center">出场图片</h3>
					<div align="center" style="width: 100%">
						<div  style="width: 50%;height: 70%;float: left;">
							<img id="out_bigImg" alt="出场" src="<%=basePath%>images/1.jpg" width="100%" height="100%">
						</div>
					</div>
					<div align="center">
						<span>
							<b>车牌号：</b>
						</span>
						<b>
						<span id="out_carNo" style="font-size: 35px;color: blue;"></span></b>
						<hr>
						<span>
							<b>车辆来源：</b>
						</span>
						<b><span id="out_carFrom" style="font-size: 35px;color: blue;"></span></b>
					</div>
				</div>
			</div><!-- ---------------------end-------------------------------------------- -->
			<!-- 显示历史记录 -->
			<div id="showOldInfo" style="overflow:auto;" class="show_"><!-- --------------------begin--------------------------------------------- -->
				<table class="table table-condensed carInfo">
				  <caption>外来车辆历史记录</caption><!-- 需要通过当前两个设备查询所有的进出信息 -->
				  <thead>
				    <tr>
				      <th>车牌号</th>
				      <th>进出时间</th>
				      <th>进出</th>
				      <th>收费</th>
				      <th>修改</th>
				     </tr>
				  </thead>
				  <tbody id="oldCarInfo">
				      <!-- 模态框 -->
				      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				      <div class="modal-dialog"><div class="modal-content"><div class="modal-header">
				      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				      <h4 class="modal-title" id="myModalLabel">修改车牌</h4></div>
				      <div class="modal-body">
				      <input type="text" style="width:100%" class="form-control" id="newCarNo"  placeholder="请输入新的车牌号"></div>
				      <div class="modal-footer">
				      <button type="button" id="close_updateCarModel" class="btn btn-default" data-dismiss="modal">关闭</button>
				      <button type="button" class="btn btn-primary exchange" id="exchange" name="" title="">提交更改</button>
				      </div></div></div></div>
				  </tbody>
				</table>
			</div><!-- --------------------------------end--------------------------------- -->
			<!-- 显示收费 -->
			<div class="show_"><!-- ------------------------begin----------------------------------------- -->
					<div align="center">
						<b >
							<span id="carNo_Fee" style="color: blue;font-size: 25px;"></span>
						</b>
						&nbsp;&nbsp;&nbsp;
						<b>收费:</b>
					<b><span style="color: red;width: 30%;font-size: 45px;" id="yfee">0.0</span></b>元
					</div>
					<hr>
					 <div align="center">
					 	<b>实际收费：</b>
					 	 <input style="width: 30%;font-style: italic;width: 30%;height: 35px;" type="text"  id="sfee" value="00.0" placeholder="实际收费">
					 </div>
					 <div align="center">
					 	<b>车辆类型：</b>
					 	 <select class="carType" style="text-align: center;font-size:13px;width: 30%;height:35px;border: 1px solid #CDC28D;">
						    	          <option value="0" selected="selected">外来车辆</option>
								         <option value="1">物业车辆</option>
								         <option value="2">军用车辆</option>
								         <option value="3">其他车辆</option>
						 </select>
					 </div>
					 <hr>
						 <div id="showCarInfoAndCommInfo" align="center">
							<!-- <span>停车时长：<b>300</b>分钟，停车收费<b>5</b>元/小时</span>
							<span>，驶入时间：<b>2016-10-12 12:13</b></span> -->
						</div>
						 <hr>
					     <button type="button" class="btn btn-primary btn-lg btn-block" id="valCharge" name="">确认收费</button>
			</div><!-- -----------------------------end------------------------------------ -->
		</div>
		<script type="text/javascript">
		  $(function(){
				  $("body").on("click",".updateCarNo",function(){
				  $(".exchange").attr("name",$(this).attr("id"));
				  $("#newCarNo").val($(this).parent().parent().children().eq(0).text());
			  });
		  });
		</script>
		<!-- 修改车牌号 -->
		<script type="text/javascript">
		 $(function(){
			 $("body").on("click",".exchange",function(){
				 var carNo=$("#newCarNo").val();
				 var vehicleId=$(this).attr("name");
				 if(carNo==null||carNo==""){
					 alert("请输入您想要修改的车牌号");
				 }else{
				 $.ajax({
					 url:'fee/updateCarNo.do',
					 data:{"carNo":carNo,"vehicleId":vehicleId},
					 type:'post',
					 success:function(res){
						 if(res.code=="200"){
							 //得到vehicleId对象
							 $("#"+vehicleId).parent().parent().children().eq(0).text(carNo);
							 $("#close_updateCarModel").click();
						 }else{
							 alert(res.message);
						 }
					 }
				 });
				 }
			 });
			 });
		</script>
		<!-- 确认收费 -->
		<script type="text/javascript">
		 $(function(){
			 $("#valCharge").click(function(){
				 var carType=$(".carType").val();
				 var paidInFee=$("#sfee").val();
				 var vehicleId=$(this).attr("name");
				 $.ajax({
					 url:'fee/valCharge.do',
					 data:{"carType":carType,"vehicleId":vehicleId,"paidInFee":paidInFee},
					 type:'post',
					 success:function(res){
						 if(res.code=="200"){
							 $("#sfee").val("");
							 $("#yfee").text("00.0");
							 $("#valCharge").attr("name","");
							 alert(res.message);
						 }else{
							 alert(res.message);
						 }
					 }
				 });
			 });
		 });
		</script>
  </body>
</html>
