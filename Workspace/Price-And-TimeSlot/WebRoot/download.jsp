<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>download</title>
	
	<link href="styles.css" rel="stylesheet" type="text/css" />

  </head>
  
 <body background="images/bg.jpg">
 <form name="" action="./download1" method="get" enctype="multipart/form-data" >
    
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="orgview.jsp" class="but"  title="">Home</a>
      <a href="./invalidMe" class="but" title="">Logout</a></div>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table height="290" width="290" border="0" align="center" > 
      <tr><td colspan="2"> 
      <p align="center"><FONT size="3" color="#ff00ff">&nbsp;&nbsp;</FONT><p align="center"><FONT size="3" color="#ff00ff"><strong>Download Form </strong><br /></FONT><p align="center"><b></FONT>
      </b> 
      </p></p></p></td></tr> 
        <tr> 
          <td><label>Enter FileID:</label></td> 
          <td><input type="text"  name="fileid" /> </td> 
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" name="submit" value="Download" /></td>
        </tr>
     </table>   
</div>
</form>
  </body>
</html>

