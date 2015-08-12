<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
	
	<link href="styles.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body background="images/bg.jpg">
  <form action="./personal" method="get"> 
    
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="userfirstpage.jsp" class="but"  title="">Home</a>
      </div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table height="382" width="290" border="0" align="center">
		<tr>
			<td colspan="2">
			<p align="center">
			<p align="center">
			<p align="center"><b>Personal Details  
      </b></p></p></p></td>
		</tr>
		<tr>
			<td><label>username:</label></td>
			<td><input type="text" name="name" /> </td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="pass" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td>Phone no:</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="register" value="Register" /></td>
		</tr>
	</table>
	<font color="RED" size="4">${Alert}</font>
</div>
</form>
  </body>
</html>
