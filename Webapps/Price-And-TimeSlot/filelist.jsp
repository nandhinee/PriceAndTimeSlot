<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>filelist</title>
	<link href="styles.css" rel="stylesheet" type="text/css" />
  </head>
  
<%! Statement st; %>
<%! ResultSet rs; String string ,username,pass,type;%>
 <% 
 	String userid=(String)session.getAttribute("userid");
 	String password=(String)session.getAttribute("password");
 
 	  Vector vii = new Vector();
 	  try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pricecloud","root","root");
			st=con.createStatement();
			
			//string="select filename , fileid from fileservice where userid='"+userid+"' and password='"+password+"'";
			string="select * from fileservice where userid='"+userid+"' and filetype='Private'";
			
			rs=st.executeQuery(string);
			
       		 Vector vii1 = new Vector();
			for(ResultSet rs = st.executeQuery(string); rs.next();)
            {
                vii1.add(rs.getString(1).toString());
                vii1.add(rs.getString(2).toString());
                vii.add(vii1);
                vii1 = new Vector();
            }
            
            string="select * from fileservice where filetype='Public'";
			
			rs=st.executeQuery(string);
			
       		for(ResultSet rs = st.executeQuery(string); rs.next();)
            {
                vii1.add(rs.getString(1).toString());
                vii1.add(rs.getString(2).toString());
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
  
 <body background="images/bg.jpg">
<div id="header" align="center">
    <div id="buttons" style="width: 515px; height: 34px">    
      <a href="orgview.jsp" class="but"  title="">Home</a>
      <a href="./invalidMe" class="but" title="">Logout</a></div>
      <p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	
	<table height="105" width="437" align="center"> 
        			<tr> 
	          			<td align="center" height="75"><FONT color="#0000ff">FileName</FONT></td> 
	          			<td align="center" height="75"><FONT color="#0000ff">FileID</FONT></td> 
	          				          			          			 
        			</tr> 
        			<tr><br /><br /></tr> 
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
          							<td align="center" width="235"><%=s1%></td> 
				          		<% 
				          		} 
				          		%>	
				          		
				          	</tr> 
          				<% 
          				} 
          			 %> 
          			 </table> 
	<p>&nbsp;</p>
	<br /><br />
	<br></p>
	   
</div>
</form>
  </body>
</html>
