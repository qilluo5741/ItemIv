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
		<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	    <link href="http://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
	  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
	  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
	  <link rel="stylesheet" href="jqueryui/style.css">
<title>Insert title here</title>
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
<body>
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
				<div class="form-group">
					 <label for="name">用户名:</label><input type="text" class="form-control" id="name" placeholder="请输入用户名" />
				</div>
				<div class="form-group">
					 <label for="carNo">车牌号:</label><input type="text" class="form-control" id="carNo" placeholder="请输入车牌号" />
				</div>
				<div class="form-group">
					 <label for="cname">车主地址:</label><input type="text" class="form-control" id="address" placeholder="请输入车主地址" />
				</div>
				<div class="form-group">
					 <label for="phone">电话号码:</label><input type="text" class="form-control"  id="phone" placeholder="请输入手机号码" />
				</div>
				<div class="form-group">
				<b>支付类型：</b>
				<select class="chargeTimeType" style="text-align: center;font-size:13px;width: 30%;height:35px;border: 1px solid #CDC28D;">
						    	          <option value="0" selected="selected">月付</option>
								         <option value="1">季付</option>
								         <option value="2">半年付</option>
								         <option value="3">年付</option>
								         </select>
				</div>
				<div class="form-group">
					 <label for="expirationTime">有效时间:</label><input type="text" class="form-control"  id="periodvalidity" placeholder="请输入有效时间"/>
				</div>
				 <input type="button" class="btn btn-default" id="resetInfo" value="重置"></input>
				 <input type="button" class="btn btn-default create" id="create" value="新建"></input>
				 <input type="button" class="btn btn-default" name="Submit" value="返回上一页" onclick="javascript:window.history.back(-1);">
		</div>
	</div>
</div>
<script type="text/javascript">
   $(function(){
	   $("#create").click(function(){
		  var commId=$('#ifm',window.parent.document).attr("name");
		  var name=$("#name").val();
		  var carNo=$("#carNo").val();
		  var address=$("#address").val();
		  var phone=$("#phone").val();
		  var time=$("#periodvalidity").val();
		  var periodvalidity=time.substring(0,4)+time.substring(5,7)+time.substring(8,10);
		  var chargeTimeType=$(".chargeTimeType").val();
		  $.ajax({
				url:'whiteList/newWhiteList.do',
				data:{"commId":commId,"name":name,"carNo":carNo,"address":address,"phone":phone,"periodvalidity":periodvalidity,"chargeTimeType":chargeTimeType},
				type:"post",
				success:function(res){
					if(res.code=="200"){
						alert(res.message);
						$('#ifm',window.parent.document).attr("src","whiteList/getWhiteList.do?commId="+commId);
					}else{
						alert(res.message);
					}
				}
			});
		});
 });
</script>
<script type="text/javascript">
	  $('.comm',window.parent.document).click(function(){
		  $('#ifm',window.parent.document).attr("src","whiteList/getWhiteList.do?commId="+$(this).attr("id"));
	  });
	</script>
	<script type="text/javascript">
	   $("#resetInfo").click(function(){
		      var name=$("#name").val("");
			  var carNo=$("#carNo").val("");
			  var address=$("#address").val("");
			  var phone=$("#phone").val("");
			  var time=$("#periodvalidity").val("");
	   });
	</script>
</body>
</html>