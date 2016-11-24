<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <link type="text/css" href="css/jquery-ui.css" rel="stylesheet" />
	    <link href="css/jquery-ui-timepicker-addon.css" type="text/css" />
	    <link href="css/demos.css" rel="stylesheet" type="text/css" />
	    <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
	    <script src="js/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
	    <!--中文-->
	    <script src="js/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" charset="gb2312"></script>
	    <script src="js/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	    <link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	    <link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
	    <mce:script src="js/jquery.ui.datepicker-zh-CN.js" mce_src="js/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></mce:script>
	    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery("#beginTime").timepicker({
                timeFormat: "HH:mm"
            });

        });
    </script>
        <script type="text/javascript">
        jQuery(function () {
            // 时间设置
            jQuery("#endTime").timepicker({
                timeFormat: "HH:mm"
            });
        });
    </script>
    <script>
	$(function(){
		$("body").on("click","#rbeginTime",function(){
			$(this).timepicker({
                timeFormat: "HH:mm"
            });
		});
	});
</script>
<script>
	$(function(){
		$("body").on("click","#rendTime",function(){
			$(this).timepicker({
                timeFormat: "HH:mm"
            });
		});
	});
</script>
</head>
<body>
<body>
			<div class="panel panel-default">
			<div class="panel-heading" style="padding-left: 13%;">
				<h4>收费模式</h4>
			</div>
			<div class="panel-body">
						<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" class="form-inline">
				<div class="form-group">
					 <label for="exampleInputEmail1">是否免费</label>
					 	<select class="form-control">
					 		<option value="isFree" selected="selected">是</option>
					 		<option value="noFree">否</option>
					 	</select>
					 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <label for="exampleInputPassword1">前</label><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="form-control" id="beforeMinute" style="width: 28%;"/><label for="exampleInputPassword1">分钟免费</label>
				</div>
				<div class="form-group">
					 <label for="exampleInputEmail1">最高收费</label><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="form-control" id="maxMoney" style="width: 28%;"/><label for="exampleInputPassword1">元</label>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="checkbox" class="form-control" id="moreDay"/><label for="exampleInputEmail1">超出天是否叠加</label>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <label for="exampleInputEmail1">未满整小时按整小时算</label>
					 <input type="checkbox" id="fullHour" class="btn btn-warning popover-toggle" 
			title="友情提示" data-container="body" 
			data-toggle="popover" data-placement="right" 
			data-content="如停车61分钟，按2小时收费。相反,停车61分钟,算1小时一分,收费取值为整。" id="moreHour">
			</form>
			</div>
			</div>
			</div>
			
			<div id="mode1">
			<div class="panel panel-default">
			<div class="panel-heading">
					模式一:<input type="checkbox"  id="charge1">
			</div>
			<div class="panel-body">
				<input  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="form-control" id="Money" style="width: 8%; float: left;" ><label for="exampleInputEmail1">元/</label>
				<label for="exampleInputEmail1">
					 	<select class="form-control">
					 		<option value="1" selected="selected">小时</option>
					 		<option value="2">次</option>
					 	</select>
			</div>
			</div>
			</div>
			
			<div id="mode2">
			<div class="panel panel-default">
			<div class="panel-heading">
				模式二:<input type="checkbox"  id="charge2">
			</div>
			<div class="panel-body">
				<label for="exampleInputEmail1">前</label>
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  id="hour" style="width: 8%;"><label for="exampleInputEmail1">小时</label>
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  id="money" style="width: 8%;"><label for="exampleInputEmail1">元</label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label for="exampleInputEmail1">满</label>
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  id="money" style="width: 8%;"><label for="exampleInputEmail1">小时</label>
				<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  id="money" style="width: 8%;"><label for="exampleInputEmail1">元</label>
				
			</div>
			</div>
			</div>
			
			<div id="mode3">
			<div class="panel panel-default" >
			<div class="panel-heading">
					模式三:<input type="checkbox"  id="charge3">
			</div>
			<div class="panel-body">
		    &nbsp;&nbsp;<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" id="hour" style="width: 8%;"><label for="exampleInputEmail1">元/</label>	
		    	<select>
				 		<option value="1" selected="selected">小时</option>
				 		<option value="2">半小时</option>
				 		<option value="3">次</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label for="beginTime">开始时间:</label><input type="text"  id="beginTime" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label for="endTime">结束时间:</label><input type="text"  id="endTime" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn btn-default" id="add" value="添加" ></input>
				<br><br />
            <table class="table" id="table1"></table>
	</div>
	</div>
	</div>
</div>
<script>
		$(function(){
			$("#mode1").click(function(){
			if($("#charge1").is(":checked")){
				$("#mode2").hide(100);
				$("#mode3").hide(100);
			}
			else{
				$("#mode2").show(100);
				$("#mode3").show(100);
			}
			});
		});
	</script>
	<script>
		$(function(){
			$("#mode2").click(function(){
			if($("#charge2").is(":checked")){
				$("#mode1").hide(100);
				$("#mode3").hide(100);
			}
			else{
				$("#mode1").show(100);
				$("#mode3").show(100);
			}
			});
		});
	</script>
	<script>
		$(function(){
			$("#mode3").click(function(){
			if($("#charge3").is(":checked")){
				$("#mode2").hide(100);
				$("#mode1").hide(100);
			}
			else{
				$("#mode2").show(100);
				$("#mode1").show(100);
			}
			});
		});
	</script>
	<script>
	$(function(){
		$(function () { $('.popover-toggle').popover('toggle');});
	});
	</script>
	<script>
	$(function(){
		$("#add").click(function(){
			$("#table1").append("<tr><td><input onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' type='text' id='hour' style='width: 23%;'><label for='exampleInputEmail1'>元/</label><select><option value='1' selected='selected'>半小时</option><option value='2'>次</option><option value='3'>小时</option><option value='4'>次/半小时</option></select></td><td><label for='rbeginTime'>开始时间:</label><input type='text'  id='rbeginTime' /></td><td><label for='rendTime'>结束时间:</label><input type='text'  id='rendTime'/></td></tr>");
		});
	})
</script>
</body>
</html>