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
  <%session.setAttribute("Alert",""); %>
  <body background="images/bg.jpg">
  <form action="./register1" method="get"><div id="header" align="center"><p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table height="110" width="488" border="0" align="center">
	<tr>
			<td colspan="4">
			<p align="center"><font color="#ff0080"><b>Preffered Time</b></font></p></td>
		</tr>
	<tr>
		<td width="110">
		<p align="center"><font color="#ff0000">Time-1</font></td>
		<td width="106">
		<p align="center"><font color="#ff0000">Time-2</font></td>
		<td width="105">
		<p align="center"><font color="#ff0000">Time-3</font></td>
		<td width="102">
		<p align="center"><font color="#ff0000">Time-4</font></td>
	</tr>	
	<tr>
		<td width="110">
		<p align="center"><font color="#8000ff">9-10</font></td>
		<td width="106">
		<p align="center"><font color="#8000ff">10-11</font></td>
		<td width="105">
		<p align="center"><font color="#8000ff">14-15</font></td>
		<td width="102">
		<p align="center"><font color="#8000ff">17-18</font></td>
	</tr>
	</table>
	&nbsp;<p>&nbsp;</p>
	<p>
	<br/>
	</p>
	<table height="110" width="441" border="0" align="center">
	<tr>
			<td colspan="4">
			<p align="center"><font color="#ff0080"><b>Memory Allocation </b></font></p></td>
		</tr>
	<tr>
		<td width="110">
		<p align="center"><font color="#ff0000">Time-1</font></td>
		<td width="106">
		<p align="center"><font color="#ff0000">Time-2</font></td>
		<td width="105">
		<p align="center"><font color="#ff0000">Time-3</font></td>
		<td width="102">
		<p align="center"><font color="#ff0000">Time-4</font></td>
	</tr>	
	<tr>
		<td width="110">
		<p align="center"><font color="#8000ff">55 mb</font></td>
		<td width="106">
		<p align="center"><font color="#8000ff">56 mb</font></td>
		<td width="105">
		<p align="center"><font color="#8000ff">54 mb</font></td>
		<td width="102">
		<p align="center"><font color="#8000ff">58 mb</font></td>
	</tr>
	</table>

	<p align="center">&nbsp;</p>
	<p align="center">&nbsp;</p>
	<p align="center">
	<img border="0" src="images/new%20rupee.png" width="22" height="30"></p>
	<p align="center"><table height="110" width="441" border="0" align="center">
	<tr>
			<td colspan="4">
			<p align="center"><font color="#ff0080"><b>Price Details Per Day </b></font></p></td>
		</tr>
	<tr>
		<td width="110">
		<p align="center"><font color="#ff0000">Time-1</font></td>
		<td width="106">
		<p align="center"><font color="#ff0000">Time-2</font></td>
		<td width="105">
		<p align="center"><font color="#ff0000">Time-3</font></td>
		<td width="102">
		<p align="center"><font color="#ff0000">Time-4</font></td>
	</tr>	
	<tr>
		<td width="110">
		<p align="center"><font color="#8000ff">150</font></td>
		<td width="106">
		<p align="center"><font color="#8000ff">200</font></td>
		<td width="105">
		<p align="center"><font color="#8000ff">100</font></td>
		<td width="102">
		<p align="center"><font color="#8000ff">500</font></td>
	</tr>
	</table>

	
	</p>
	<p align="center">&nbsp;</p>
	<p align="center">
	<br/>
	</p>
	<table height="239" width="365" border="0" align="center">
		<tr>
			<td colspan="2">
			<p align="center">
			<p align="center">
			<p align="center"><b>Cloud Details 
      </b></p></p></p></td>
		</tr>
		<tr>
			<td>Start-Date<label>:</label></td>
			<td><input type="text" name="start" />&nbsp; dd-mm-yyyy</td>
		</tr>
		<tr>
			<td>End-Date:</td>
			<td><input type="text" name="end" />&nbsp; dd-mm-yyyy</td>
		</tr>
		<tr>
			<td>Preffered Time:</td>
			<td><select name="time">
				<option >Select Preffered Time</option>
				<option value="Time-1">Time-1</option>
				<option value="Time-2">Time-2</option>
				<option value="Time-3">Time-3</option>
				<option value="Time-4">Time-4</option>
			</select></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="register" value="Next" /></td>
		</tr>
	</table>   
</div>
</form>
  </body>
</html>