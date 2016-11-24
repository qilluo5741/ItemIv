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
    <title>小区管理</title>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/pagination.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery.pagination.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript">
	function handlePaginationClick(new_page_index, pagination_container) {
	    $("#supplierForm").attr("action","commun/getCommunityInfo.do?pageIndex="+(new_page_index+1));
	    $("#supplierForm").submit();
	    return false;
	}
  	$(function(){
			$("#News-Pagination").pagination(${pager.totalPages},{
		        items_per_page:${pager.pageSize},
		        current_page:${pager.pageIndex}- 1,
		        num_display_entries:2,
		        next_text:"下一页",
		        prev_text:"上一页",
		        maxentries:${pager.totalPages},
		        num_edge_entries:3,
		        callback:handlePaginationClick
			});
		});
  	</script>
  </head>
  <body>
  <div align="right"><br/>
	 	<input  name="commName" placeholder="请输入小区名字" value="${key}" id="commName" style="border-radius:9px;width:220px;background-color:#eee;border:0;">&nbsp;&nbsp;
	  	<button id="ss" type="button" class="btn btn-info">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
  	<table class="table table-striped">
		   <thead>
		      <tr>
		         <!-- <th>小区主键</th> -->
		         <!-- <th>小区标识</th> -->
		         <th>停车场名字</th>
		         <th>创建时间</th>
		         <th>收费管理</th>
		         <th>车位管理</th>
		         <th>是否允许外来车辆入内</th>
		      </tr>
		   </thead> 
		   <tbody>
		    	<c:forEach  items="${pager.list}" var="p">
		    		  <tr>
				         <%-- <td>${p.commId}</td> --%>
				         <%-- <td>${p.commVal}</td> --%>
				         <td>${p.commName}</td>
				         <td>${fn:substring(p.createtime,0,10)}</td>
				         <td>
				            <button class="btn btn-default updateFeeType" data-toggle="modal" data-target="#myModal" id="updateFeeType" name="${p.commVal}" style="background-color: #EECBAD">修改收费模式</button>
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												修改收费模式
											</h4>
										</div>
										<div class="modal-body">
											<div class="input-group" style="float: left;width: 100%;">
							         <input type="text" class="form-control" id="money"/><span class="input-group-addon">/元</span>
							         <select id="feeModel" class="form-control">
							         	<option value="1">小时</option>
							         	<option value="2">次</option>
							         </select>
							        </div>
							        <br><br />
							        <label for="freeMin">最高收费金额(元)</label>
							        <input type="text" id="maxMoney" class="form-control" placeholder="最高收费金额" />
							        <br>
							        <label for="freeMin">前多少分钟免费(元)</label>
							        <input type="text" id="freeMin" class="form-control" placeholder="前多少分钟免费" />
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭
											</button>
											<button type="button" class="btn btn-primary resetFeeType" id="resetFeeType" name="">
												修改
											</button>
										</div>
									</div>
								</div>
							</div>
				         </td>
				         <td>
				         <button class="btn btn-default updatePsCount" data-toggle="modal" data-target="#myModal1" id="updatePsCount" name="${p.commVal}" style="background-color: #EEAEEE" >修改车位数</button>
				         <!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												修改车位总数
											</h4>
										</div>
										<div class="modal-body">
							        <label for="freeMin">当前闲置车位总数</label>
							        <input type="text" id="psCount" class="form-control psCount" readonly="readonly"/>
							        <br>
							        <label for="freeMin">修改闲置车位总数</label>
							        <input type="text" id="afterPsCount" class="form-control" placeholder="修改车位总数" />
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭
											</button>
											<button type="button" class="btn btn-primary resetPsCount" id="resetPsCount" name="">
												修改
											</button>
										</div>
									</div>
								</div>
							</div>
				         </td>
				         <td>
				         <button class="btn btn-default reset" data-toggle="modal" data-target="#myModal2" id="updatePsCount" name="${p.commVal}" style="background-color: #EEAEEE" >修改</button>
				         <!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												修改是否允许外来车辆入内停车
											</h4>
										</div>
										<div class="modal-body">
										<span style="color: #FF7256">(提示:当前选中的状态为目前停车场的状态)</span><br>
										<input type="radio" name="isBanOnForeignCars" value="1" id="allow" class="state">允许
										<input type="radio" name="isBanOnForeignCars" value="0" id="refuse" class="state">禁止
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭
											</button>
											<button type="button" class="btn btn-primary isBanOnForeignCars" id="resetPsCount" name="">
												修改
											</button>
										</div>
									</div>
								</div>
							</div>
				         </td>
				      </tr>
		    	 </c:forEach>
	   	   </tbody>
	</table>
	<script type="text/javascript">
		$(function(){
			$("#ss").click(function(){
				$("#key").val($("#commName").val());
				$("#supplierForm").attr("action","commun/getcommunitylist.do?pageIndex="+(1));
				$("#supplierForm").submit();
			})
		});
	</script>
	<form id="supplierForm"  method="post" action="">
		<div style="height:20px;" id="News-Pagination"  align="left"></div>
		<input id="key" name="key" type="hidden" value="${key}">
	</form>
	<script type="text/javascript">
	   $(function(){
		   $(".updateFeeType").click(function(){
			   $(".resetFeeType").attr("name",$(this).attr("name"));
			   var commId=$(this).attr("name");
			   $.ajax({
				   url:'fee/getFeeTypeByCommId.do',
				   data:{"commId":commId},
				   type:'post',
				   dataType:'json',
				   success:function(data){
					   $("#money").val(data.result.money);
					   $("#maxMoney").val(data.result.maxMoney);//最高收费金额
					   $("#feeModel").val(data.result.feeModel);//当feemodel等于1时  为/小时    等于2时 为/次
					   $("#freeMin").val(data.result.freeMin);//前多少分钟免费
				   }
			   });
		   });
	   });
	</script>
	<script type="text/javascript">
	  $(function(){
		  $("#resetFeeType").click(function(){
			var commId=$(this).attr("name");
		    var money=$("#money").val();
			var feeModel=$("#feeModel option:selected").val();
			var maxMoney=$("#maxMoney").val();
			var freeMin=$("#freeMin").val();
			$.ajax({
				url:'fee/updateFeeTypeByCommId.do',
				data:{"money":money,"feeModel":feeModel,"maxMoney":maxMoney,"commId":commId,"freeMin":freeMin},
				type:'post',
				success:function(res){
					if(res.code=="200"){
						alert(res.message);
						location.reload();
					}
					else{
						alert(res.message);
					}
				}
			});
		  });
	  });
	</script>
	
	<script type="text/javascript">
	   $(function(){
		   $(".updatePsCount").click(function(){
			   $(".resetPsCount").attr("name",$(this).attr("name"));
			   var commId=$(this).attr("name");
			   $.ajax({
				   url:'commun/getCommPsCount.do',
				   data:{'commId':commId},
				   type:'post',
				   dataType:'json',
				   success:function(data){
					   $("#psCount").val(data.result);
				   }
			   });
		   });
	   });
	</script>
	<script type="text/javascript">
	  $(function(){
		 $(".resetPsCount").click(function(){
			 var psCount=$("#afterPsCount").val();
			 var nowPsCount=$(".psCount").val();
			 var commId=$(this).attr("name");
			 $.ajax({
				 url:'commun/updateCommPsCount.do',
				 data:{"psCount":psCount,"commId":commId},
				 type:'post',
				 success:function(res){
					 if(res.code=="200"){
						 alert(res.message);
						 location.reload();
					 }else{
						 alert(res.message);
						 location.reload();
					 }
				 }
			 });
		 }); 
	  });
	</script>
	<script type="text/javascript">
	$(function(){
		$(".reset").click(function(){
			$(".isBanOnForeignCars").attr("name",$(this).attr("name"));
			$.ajax({
				url:'commun/getisBanOnForeignCars.do',
				data:{"commId":$(this).attr("name")},
				type:'post',
				dataType:'json',
				success:function(data){
					if(data.result==0){
						$("#refuse").attr("checked","checked");
					}
					if(data.result==1){
						$("#allow").attr("checked","checked");
					}
				}
			});
		});
	});
	</script>
	<script type="text/javascript">
	   $(function(){
		   $(".isBanOnForeignCars").click(function(){
			   var commId=$(this).attr("name");
			   var isBanOnForeignCars=$('input[name="isBanOnForeignCars"]:checked').val();
			   $.ajax({
				   url:'commun/updateisBanOnForeignCars.do',
				   data:{"commId":commId,"isBanOnForeignCars":isBanOnForeignCars},
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
