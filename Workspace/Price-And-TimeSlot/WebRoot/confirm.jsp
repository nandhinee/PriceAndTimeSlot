<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Confirm</title>
    
	
	<link href="styles.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body background="images/bg.jpg">
  <form action="./confirm" method="get"><div id="header" align="center"><p>&nbsp;</p>
	<p>&nbsp;</p>
	
	
	<p align="center">
	</p>
	<p align="center">&nbsp; <br></p>
	<p align="center">
	<br/>
	</p>
	<table height="239" width="365" border="0" align="center">
		<tr>
			<td colspan="2">
			<p align="center">
			<p align="center">
			<p align="center"><b>Payment Form  
      </b></p></p></p></td>
		</tr>
		<tr>
			<td>Bank Name:</td>
			<td><select name="bank">
				<option >Select Preffered Bank</option>
				<option value="HDFC">HDFC</option>
				<option value="SBI">SBI</option>
				<option value="AXIS">AXIS</option>
				<option value="IOB">IOB</option>
			</select></td>
		</tr>
		
		<tr>
			<td>Account no:</td>
			<td><input type="password" name="accno" />&nbsp; <br></td>
		</tr>
		<tr>
			<td>CVV no:</td>
			<td><input type="password" name="cvvno" /></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="register" value="Submit" /></td>
		</tr>
	</table>   
</div>
</form>
  </body>
</html>