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
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="orgview.jsp" class="but"  title="">Home</a>
      <a href="fileupload.jsp" class="but" title="">Back</a>
      <a href="./invalidMe" class="but" title="">Logout</a>
      </div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p><p><br></p><p><font size="5"><strong>Success Page</strong></font><br></p>
	   
</div>
</form>
  </body>
</html>
