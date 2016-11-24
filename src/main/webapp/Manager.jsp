<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html">
<html lang="en">
	<html lang="en" class="ie7">
	<html lang="en" class="ie8">
	<html lang="en" class="ie9">
	<html lang="en" class="ie10">
	<html lang="en" class="ie11">
	<html lang="en">
<html>
	<head>
		<meta charset="utf-8" />
		<title>停车管理系统</title>
		<meta name=”renderer” content=”webkit” /> 
		<meta name=”renderer” content=”ie-comp” /> 
		<meta name=”renderer” content=”ie-stand” />
		<meta name="author" content="FREEHTML5.CO" />
		<meta property="og:title" content=""/>
		<meta property="og:image" content=""/>
		<meta property="og:url" content=""/>
		<meta property="og:site_name" content=""/>
		<meta property="og:description" content=""/>
		<meta name="twitter:title" content=""/>
		<meta name="twitter:image" content=""/>
		<meta name="twitter:url" content="" />
		<meta name="twitter:card" content="" />
		<meta accesskey="" charset="" contenteditable="inherit" dir="rtl"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<meta name=”renderer” content=”webkit|ie-comp|ie-stand”/>
		<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
		<meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery-1.8.3.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
		<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
		<style>
			p{margin:0;padding:0;}
			#record .box{width:100%;height: 44%;}
			#record .box .img{float:right; width: 40%;height: 100%;}
			#record .box .img img{width:100%;height:86%;}
			#record .box .list{float:left;width:58%;display:inline;height: 100%;}
			#parkCharge .carNoConfirm{width: 100%;height: 40%;}
			#parkCharge .carNoConfirm #NoCarNo{width: 100%;height: 20%;}
		</style>
</head>
<body>
<body style="background-color:#F5FFFA;">
		<div class="muban">
			<h4 class="text-center text-success">
				入场图片
			</h4><img alt="入场图片" src="img/1.jpg" class="img-rounded" width="50%" style="align-content: center; margin-left: 100px;"/>
			<br><br />
			<p>
				 车牌:<input type="text" id="inCarNo1" class="plate" value="沪" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo2" class="plate" value="A"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo3" class="plate" value="1"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo4" class="plate" value="2"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo5" class="plate" value="3"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo6" class="plate" value="4"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="inCarNo7" class="plate" value="5"  maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
			</p>
			类型:<input id="parkType" value="临停" readonly="readonly" style="border: none;width: 20%;background-color: #F5FFFA;">
			<br>
			时间:<input id="beginTime" value="2016:09:24 10:26" readonly="readonly" style="border: none;background-color: #F5FFFA;">
				 <input type="button"  id="changeInCarNO" value="修订" style="margin-left: 100px; width: 50px;border: none;background-color:#FFC125 ;"/>
			</input>
		</div>
		<div class="muban">
			<h4 class="text-center text-success">
				车牌对比
			</h4>
			<h2 align="center">
				    <input type="text" id="CarNo1" class="plate" value="沪"maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo2" class="plate" value="A" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo3" class="plate" value="1" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo4" class="plate" value="2" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo5" class="plate" value="3" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo6" class="plate" value="4" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="CarNo7" class="plate" value="5" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
			</h2>
			<ol>
				<li style="border-bottom:1px solid red">
					<a href="#" style="text-decoration: none;"><input type="button" id="list1" style="border: none;background-color: #F5FFFA;" value="沪A12345"/></input></a>
				</li><br>
				<li style="border-bottom:1px solid red">
					<a href="#" style="text-decoration: none;"><input type="button" id="list2" style="border: none;background-color: #F5FFFA;" value="沪A12345"/></input></a>
				</li><br>
				<li style="border-bottom:1px solid red">
					<a href="#" style="text-decoration: none;"><input type="button" id="list3" style="border: none;background-color: #F5FFFA;" value="沪A12345"/></input></a>
				</li><br>
				<li style="border-bottom:1px solid red">
					<a href="#" style="text-decoration: none;"><input type="button" id="list4" style="border: none;background-color: #F5FFFA;" value="沪A12345"/></input></a>
				</li>
			</ol>
		</div>
		<div class="muban">
			<h4 class="text-center text-success">
				出场图片
			</h4><img alt="出场图片" src="img/1.jpg" class="img-rounded" width="50%" style="align-content: center; margin-left: 100px;"/>
			<br><br />
			<p>
				 车牌:<input type="text" id="outCarNo1" class="plate" value="沪" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo2" class="plate" value="A" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo3" class="plate" value="1" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo4" class="plate" value="2" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo5" class="plate" value="3" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo6" class="plate" value="4" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					  <input type="text" id="outCarNo7" class="plate" value="5" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
			</p>
			类型:<input id="parkType" value="临停" readonly="readonly" style="border: none;width: 20%;background-color: #F5FFFA;">
			<br>
			时间:<input id="beginTime" value="2016:09:24 10:26" readonly="readonly" style="border: none;background-color: #F5FFFA;">
				 <input type="button"  id="changeOutCarNO" value="修订" style="margin-left: 100px; width: 50px;border: none;background-color:#FFC125 ;"/>
			</input>
		</div>
		<div class="muban">
			<h4 class="text-center text-success" style="padding-right: 20%;">
				报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表
			</h4>
			<ol>
				<li>
					Lorem ipsum dolor sit amet
				</li>
				<li>
					Consectetur adipiscing elit
				</li>
				<li>
					Integer molestie lorem at massa
				</li>
				<li>
					Facilisis in pretium nisl aliquet
				</li>
				<li>
					Nulla volutpat aliquam velit
				</li>
				<li>
					Faucibus porta lacus fringilla vel
				</li>
				<li>
					Aenean sit amet erat nunc
				</li>
				</ol>
				</div>
			<div class="muban" id="record">
			<h4 class="text-success text-center">
				<span style="text-align: center; margin-bottom: 50px;">记&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</span>
			</h4>
			<div class="box">
			    <div class="img">
			        <img src="img/1.jpg" alt="入场历史图片"/>
			    </div>
			    <div class="list">
			    	<p>入场历史图片</p>
			    	<br><br/>
			        <p>
			   车牌:<input type="text" id="inReCarNo1" class="plate" value="沪"maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo2" class="plate" value="A" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo3" class="plate" value="1" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo4" class="plate" value="2" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo5" class="plate" value="3" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo6" class="plate" value="4" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="inReCarNo7" class="plate" value="5" maxlength="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					</p>
					类型:<input id="parkType" value="临停" readonly="readonly" style="border: none;text-align: center;background-color: #F5FFFA;"></input><br>
			        时间:<input id="beginTime" value="2016:09:24 10:26" readonly="readonly" style="border: none;background-color: #F5FFFA;">
					<input type="button"  id="changeInReCarNO" value="修订" style="width: 100%;border: none;"/>
			    </div>
			</div>
			<div class="box">
			    <div class="img">
			        <img src="img/1.jpg" alt="出场历史图片"/>
			    </div>
			    <div class="list">
			    	<p>出场历史图片</p>
			    	<br><br/>
			        <p>
			   车牌:<input type="text" id="outReCarNo1" class="plate" value="沪"style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo2" class="plate" value="A" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo3" class="plate" value="1" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo4" class="plate" value="2" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo5" class="plate" value="3" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo6" class="plate" value="4" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					<input type="text" id="outReCarNo7" class="plate" value="5" style="width: 30px;border: 1px solid #CDC28D;background-color: #FFC125;"/>
					</p>
					类型:<input id="parkType" value="临停" readonly="readonly" style="border: none;text-align: center;background-color: #F5FFFA;"></input><br>
			        时间:<input id="endTime" value="2016:09:24 10:26" readonly="readonly" style="border: none;background-color: #F5FFFA;">
			    </div>
			</div>
		</div>
		<div class="muban" id="parkCharge">
			<h4 class="text-center text-success">
				收&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费
			</h4>
			应收费用:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="receivable" value="50" readonly="readonly" style="width: 10%;border:none;background-color: #F5FFFA;text-align: center;">元</input>
			<br>
			<p>
				实收费用:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="realPrice" value="" style="width: 10%;border: 1px solid #CDC28D;background-color: #E6E6E6;text-align: center;"/>元
			</p>
			<p>
				车辆类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select class="carType" style="background-color: #DBDBDB;text-align: center;font-size:13px;width: 30%;height:10%;border: 1px solid #CDC28D;background-color: #E6E6E6;">
					         <option value="1">物业车辆</option>
					         <option value="2">军用车辆</option>
					         <option value="3">其他车辆</option>
					         </select><br />
			</p>
            <br><br />
			<input type="button"  id="confirm" value="确认" style="margin-left: 100px; width: 100px;border: none;background-color:#FFC125 ;"/>
			<div class="carNoConfirm">
			<input type="button"  id="inputCarNo" value="无车牌录入                                                                           >" style="width: 96%;border: none; padding-bottom:5px; border-bottom:1px solid #000;margin: 2%;text-align: left;padding-left: 15px;"/>
			<ul>
				<li style="list-style-type:none; border-bottom:1px solid red"><span>沪A12345</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  id="NoCarNo" value="未收费" style="width: 100px;border: none;margin: 2%;"/></li>
				<li style="list-style-type:none; border-bottom:1px solid red"><span>沪A12345</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  id="NoCarNo" value="已收费" style="width: 100px;border: none;margin: 2%;"/></li>
			</ul>
			</div>
		</div>
		<script>
			$(function(){
				$("#changeInCarNO").click(function(){
					var carNo1=$("#inCarNo1").val();
					var carNo2=$("#inCarNo2").val();
					var carNo3=$("#inCarNo3").val();
					var carNo4=$("#inCarNo4").val();
					var carNo5=$("#inCarNo5").val();
					var carNo6=$("#inCarNo6").val();
					var carNo7=$("#inCarNo7").val();
					var carNo=carNo1+carNo2+carNo3+carNo4+carNo5+carNo6+carNo7;
					$("#inReCarNo1").val(carNo1);
					$("#inReCarNo2").val(carNo2);
					$("#inReCarNo3").val(carNo3);
					$("#inReCarNo4").val(carNo4);
					$("#inReCarNo5").val(carNo5);
					$("#inReCarNo6").val(carNo6);
					$("#inReCarNo7").val(carNo7);
					alert("修改成功"+carNo);
				})
			})
		</script>
		<!--修改出场车牌号-->
		<script>
			$(function(){
				$("#changeOutCarNO").click(function(){
					var carNo1=$("#outCarNo1").val();
					var carNo2=$("#outCarNo2").val();
					var carNo3=$("#outCarNo3").val();
					var carNo4=$("#outCarNo4").val();
					var carNo5=$("#outCarNo5").val();
					var carNo6=$("#outCarNo6").val();
					var carNo7=$("#outCarNo7").val();
					var carNo=carNo1+carNo2+carNo3+carNo4+carNo5+carNo6+carNo7;
					/*同步修改车牌对比的车牌号*/
					$("#CarNo1").val(carNo1);
					$("#CarNo2").val(carNo2);
					$("#CarNo3").val(carNo3);
					$("#CarNo4").val(carNo4);
					$("#CarNo5").val(carNo5);
					$("#CarNo6").val(carNo6);
					$("#CarNo7").val(carNo7);
					/*同步修改出场历史图片的车牌号*/
					$("#outReCarNo1").val(carNo1);
					$("#outReCarNo2").val(carNo2);
					$("#outReCarNo3").val(carNo3);
					$("#outReCarNo4").val(carNo4);
					$("#outReCarNo5").val(carNo5);
					$("#outReCarNo6").val(carNo6);
					$("#outReCarNo7").val(carNo7);
					alert("修改成功"+carNo);
				})
			})
		</script>
		<!--修改入场历史车牌号-->
		<script>
			$(function(){
				$("#changeInReCarNO").click(function(){
					var carNo1=$("#inReCarNo1").val();
					var carNo2=$("#inReCarNo2").val();
					var carNo3=$("#inReCarNo3").val();
					var carNo4=$("#inReCarNo4").val();
					var carNo5=$("#inReCarNo5").val();
					var carNo6=$("#inReCarNo6").val();
					var carNo7=$("#inReCarNo7").val();
					var carNo=carNo1+carNo2+carNo3+carNo4+carNo5+carNo6+carNo7;
					alert("修改成功"+carNo);
				})
			})
		</script>
		<!--修改车牌对比的车牌号码-->
		<script>
			$(function(){
				/*修改第一条*/
				$("#list1").click(function(){
					var test=$("#list1").val();
					$("#CarNo1").val(test.substring(0,1));
					$("#CarNo2").val(test.substring(1,2));
					$("#CarNo3").val(test.substring(2,3));
					$("#CarNo4").val(test.substring(3,4));
					$("#CarNo5").val(test.substring(4,5));
					$("#CarNo6").val(test.substring(5,6));
					$("#CarNo7").val(test.substring(6,7));
					alert(test);
				});
			});
		</script>
		<script>
			$(function(){
				/*修改第二条*/
				$("#list2").click(function(){
					var test=$("#list1").val();
					$("#CarNo1").val(test.substring(0,1));
					$("#CarNo2").val(test.substring(1,2));
					$("#CarNo3").val(test.substring(2,3));
					$("#CarNo4").val(test.substring(3,4));
					$("#CarNo5").val(test.substring(4,5));
					$("#CarNo6").val(test.substring(5,6));
					$("#CarNo7").val(test.substring(6,7));
					alert(test);
				});
			});
		</script>
		<script>
			$(function(){
				/*修改第三条*/
				$("#list3").click(function(){
					var test=$("#list1").val();
					$("#CarNo1").val(test.substring(0,1));
					$("#CarNo2").val(test.substring(1,2));
					$("#CarNo3").val(test.substring(2,3));
					$("#CarNo4").val(test.substring(3,4));
					$("#CarNo5").val(test.substring(4,5));
					$("#CarNo6").val(test.substring(5,6));
					$("#CarNo7").val(test.substring(6,7));
					alert(test);
				});
			});
		</script>
		<script>
			$(function(){
				/*修改第四条*/
				$("#list4").click(function(){
					var test=$("#list1").val();
					$("#CarNo1").val(test.substring(0,1));
					$("#CarNo2").val(test.substring(1,2));
					$("#CarNo3").val(test.substring(2,3));
					$("#CarNo4").val(test.substring(3,4));
					$("#CarNo5").val(test.substring(4,5));
					$("#CarNo6").val(test.substring(5,6));
					$("#CarNo7").val(test.substring(6,7));
					alert(test);
				});
			});
		</script>
</body>
</html>