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
<script type="text/javascript">
		function Validate(){
		  	var image =document.getElementById('uploaded').value;
		  	if(image!=''){
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.gif|\.GIF|\.jpeg|\.JPEG|\.3gp|\.avi|\.mpg|\.mpeg|\.flv|\.mp4|\.html|\.txt|\.doc|\.docx|\.java)$/)){
			 alert("Please enterFile Extensions .jpg,.png,.html,java");
			 document.getElementById('uploaded').focus();
			  return false;
			}
		  }
		   return true;
		 }
</script>

  </head>
  
 <body background="images/bg.jpg">
 <form name="" action="./upload" method="post" enctype="multipart/form-data" onsubmit="return Validate();" >
    
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
      <p align="center">&nbsp;&nbsp;<p align="center"><FONT size="3" color="#ff00ff"><strong>File Storage Form </strong></FONT><br /><p align="center"><b></FONT>
      </b> 
      </p></p></p></td></tr> 
        <tr> 
          <td><label>Upload:</label></td> 
          <td><input type="file" value="file" name="uploaded" id="uploaded"/> </td> 
        </tr> 
        <tr>
        <td colspan="2" align="center"><input type="radio" name="chooserad" value="Private" checked="checked"/>  <strong>Private</strong></td>
      </tr>
      <tr>
          <td colspan="2" align="center"><input type="radio" name="chooserad" value="Public" /> <strong>Public</strong></td>
          </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" name="submit" value="submit" /></td>
        </tr>
        
      </table>   
</div>
</form>
  </body>
</html>
