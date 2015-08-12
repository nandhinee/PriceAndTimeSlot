<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>display</title>
    
	
	<link href="styles.css" rel="stylesheet" type="text/css" />

  </head>
  <%
	String filename=session.getAttribute("filename").toString();
	String serverpath=session.getAttribute("serverpath").toString();
 %>
  
 <body background="images/bg.jpg">
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="orgview.jsp" class="but"  title="">Home</a>
      <a href="download.jsp"  class="but" title="">Back</a>
      <a href="./invalidMe" class="but" title="">Logout</a></div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p><p>
	<table align="center"> 
	<tr> 
		<td align="center"><FONT size="4"><strong>Download Page</strong></FONT></td> 
	</tr> 
	</table>
	<br></p><p>
	
	<br></p>
	 <%
	serverpath="downloadlink1?link="+serverpath.toString();
 	%>  
 	<table height="100" width="369" border="0" align="center">  
     <tr> 
     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Click here <a href="<%=serverpath%>"><%=filename%></a> To Get your file</td> 
     </tr> 
    </table> 
</div>
  </body>
</html>
