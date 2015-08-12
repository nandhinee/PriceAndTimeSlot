<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	
	<link href="styles.css" rel="stylesheet" type="text/css" />

  </head>
  
 <body background="images/bg.jpg">
 <form action="./timerequest" method="get" enctype="multipart/form-data">
    
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="orgview.jsp" class="but"  title="">Home</a>
      <a href="request.jsp" class="but" title="">Back</a>
      </div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table height="238" width="290" border="0" align="center">
		<tr>
			<td colspan="2">
			<p align="center">
			<p align="center">
			<p align="center"><b>Time Request
      </b></p></p></p></td>
		</tr>
		<tr>
			<td><label>Start Time:</label></td>
			<td><input type="text" name="Start" value=""  /> </td>
		</tr>
		<tr>
			<td>End Time:</td>
			<td><input type="text" name="End" value=""  /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="submit" value="Send Request" /></td>
		</tr>
	</table>   
</div>
</form>
  </body>
</html>
