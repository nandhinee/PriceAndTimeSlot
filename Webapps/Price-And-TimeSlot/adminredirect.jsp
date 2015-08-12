<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>
<%! Statement st; %>
<%! ResultSet rs; String string ,username,pass,type;%>
 <% 
 	  Vector vii = new Vector();
 	  try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pricecloud","root","root");
			st=con.createStatement();
			
			string="select * from cloudreq";
			
			rs=st.executeQuery(string);
			
       		 Vector vii1 = new Vector();
			for(ResultSet rs = st.executeQuery(string); rs.next();)
            {
                vii1.add(rs.getString(1).toString());
                vii1.add(rs.getString(2).toString());
                vii1.add(rs.getString(3).toString());
                vii.add(vii1);
                vii1 = new Vector();
            }
			rs.close();
			st.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
  %>
<body>
<form name="" action="./adminredirect" method="get" enctype="multipart/form-data" >
<div id="mainbody" >
  <div id="topheader"> <a href="#"><img src="images/logo.jpg" title="Business Company" alt="Business Company" width="194" height="47" border="0" /></a>
   <ul style="background-color: rgb(0, 255, 0);">
      <li class="Home"><font size="4" ><a href="firstpage.jsp">&nbsp;LogOut</a></font></li>
      <li class="Approve"><font size="4"><a href="requestaccept.jsp">&nbsp;&nbsp;&nbsp;&nbsp; Request &nbsp; &nbsp; &nbsp; <br /></a></font></li>
      <li class=""><font size="4"><a href="admin1.jsp">UserDetails</a></font></li>
      <li class=""><font size="4"><a href="Map.jsp">&nbsp;&nbsp;&nbsp; RiskMap</a></font></li>
       <li class=""><font size="4"><a href="currentuser.jsp">&nbsp; &nbsp; OnlineUser</a></font></li>
    </ul>
  </div>
  <div id="topback">
    <h2>welcome</h2>
    <p><span>LOREM IPSUM DOLOR</span><br/>
      Dolores et ea consetetur sadi pscing elit consetetur pscing elitr, sed diam nonumy consetetur sadi pscing elit consetetur pscing elitr, sed diam nonumy consetetur sadi lorem sed lorem ipsum consetetur pscing consetetur lorem ipsum</p>
    <ul>
      <li><a href="#">Dolores et ea consetetur sadi </a></li>
      <li><a href="#">pscing elit consetetur pscing elitr,</a></li>
      <li><a href="#">sed diam nonumy consetetur sadi </a></li>
      <li><a href="#">pscing elit consetetur pscing</a></li>
      <li><a href="#">elitr, sed diam nonumy consetetur </a></li>
    </ul>
    <ul class="ask">
      <li><a href="#" title="Enter"></a></li>
    </ul>
  </div>
  <div id="bodypan">
    <div id="leftpan" style="width: 755px; height: 379px" >
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<table height="70" width="449" align="center"> 
        			<tr> 
	          			<td align="center" height="31"><FONT color="#0000ff">Start Time</FONT></td> 
	          			<td align="center" width="116" height="31"><FONT color="#0000ff">End Time</FONT></td> 
	          			<td align="center" height="31"><FONT color="#0000ff">UserId</FONT></td> 	          				          			          			 
        			</tr> 
        			<tr></tr> 
        			<tr></tr> 
					<% 
						String s1="";
						String s2="";
          				for( int i=0;i<vii.size();i++) 
          				{           						
          						String	st=vii.get(i).toString(); 
          						System.out.println("...test..."+st); 
          						st=st.replace("["," "); 
          						st=st.replace("]"," "); 
          						 
          						StringTokenizer str=new StringTokenizer(st,","); 
          						%> 
				          		<tr align="center"> 
				          		<% 
          						while(str.hasMoreTokens()) 
          						{ 
          							s1=str.nextToken(); 
          							
          						%> 
          							<td align="center" width="132"><font color="Black" size="2"><%=s1%></font></td> 
				          		<% 
				          		} 
				          		%>	
				          		
				          	</tr> 
          				<% 
          				} 
          			 %> 
          			 </table> 
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<br /><br />
					<table align="center" width="235" height="74">
        			<tr>
        			<td colspan="2" align="center"><font color="Black" size="2">UserID :</font></td>
          			<td colspan="2" align="center"><input type="text" name="userid" /></td>
       				 </tr> 	
       				 <tr>
        			<td colspan="2" align="center"><font color="Black" size="2">URL :</font></td>
          			<td colspan="2" align="center"><input type="text" name="url" /></td>
       				 </tr> 
	          		</table></p>
          			
        			 <table align="center" style="width: 81px; height: 34px;">
        			<tr>
          			<td colspan="2" align="center"><input type="submit" value=" Accept " /></td>
       				 </tr>         		
	          		</table></p></div>
  </div>
  <div id="footer">
    <p><a href="#">HOME</a> | <a href="#">ABOUT US</a> | <a href="#">SERVICES</a> | <a href="#">PARTNERS</a> | <a href="#">SUPPORT</a> | <a href="#">NEWS &amp; EVENTS</a> | <a href="#">CONTACTS</a><br/>
      Copyright &copy; Your Company Name. Designed by <a href="http://www.freecsstemplates.com" target="_blank">FreeCSSTemplates.com</a></p>
    <img src="images/callus.jpg" alt="" width="123" height="37" /></div>
</div>
</form>
</body>
</html>