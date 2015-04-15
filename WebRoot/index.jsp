<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
    <title>MyHtml.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link rel="stylesheet" type="text/css" href="css/fullcalendar.css"> 
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css"> 
    <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/ >
    <link rel="stylesheet" type="text/css" href="css/customFullCalendar.css"> 
    
	<script src="js/jquery.min.js"></script> 
	<script src="js/jquery-ui.custom.min.js"></script> 
	<script src="js/moment.min.js"></script>  
	<script src="js/fullcalendar.js"></script> 
	<script src="js/zh-cn.js"></script> 
	
	<script src="js/jquery.datetimepicker.js"></script>
	
	<script src="js/main.js"></script>  

  </head>
  
  <body>
 <div id="main">
     <div id="left" class="fc_left">
       <div id="datetimepicker"></div>
       
       <div id="meetingRoom">
			<div class="ch"><h4>会议室</h4></div>
			<ul>
              <li><span class="selected">room1</span></li>
              <li><span>room2</span></li>
              <li><span>room3</span></li>
              </ul>

		</div>
		
     </div>
     
     <div id="right" class="fc_right" >
	      <div id='calendar'></div> 
	</div>
	
 </div>
  </body>
</html>
