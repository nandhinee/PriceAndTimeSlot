<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page  import="java.awt.*"  %>
<%@page import="java.util.Vector"%>
<%@ page  import="java.io.*"%>
<%@ page  import="org.jfree.chart.*" %> 
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page  import="java.sql.*"%>
<%@ page  import="DataBase.DBConnection"%>
<%@ page  import="user.com.Duplicate" %>
<%@page import="java.util.Iterator"%> 
<%	
	DBConnection db=new DBConnection();
	Connection con;
	Statement st;
	con=db.getConnection();
	st=con.createStatement();
	Vector ect= new Vector();
	
	/*
	//String sql="select * from userdetails";
	//ResultSet rs=st.executeQuery(sql);
	//while(rs.next())
	//{
		//ect.add(rs.getString(1));
	}*/
	String na="";
	Duplicate dup=new Duplicate();
	ect = dup.getVector();
	Vector vnew=new Vector();
	Iterator it=ect.iterator();
	while(it.hasNext())
	{
	vnew=(Vector) it.next();
	}
	System.out.println("------>Vnew"+vnew);
	int res=vnew.size()/2;
	System.out.println("------>"+res);
	//int size=ect.size();
  //System.out.println(".....ssss......"+size);
  final DefaultPieDataset data = new DefaultPieDataset();
  data.setValue("Total", new Integer(20));
  data.setValue("Risk", new Integer(res));
  //data.setValue("occupaid", new Integer());
  JFreeChart chart = ChartFactory.createPieChart
  ("Pie Chart ", data, true, true, false);

			 try {
					 final ChartRenderingInfo info = new 
					 ChartRenderingInfo(new StandardEntityCollection()); 
					 final File file1 = new File("webapps/Price-And-TimeSlot/images/piechart.jpg");
					 ChartUtilities.saveChartAsPNG(
					  file1, chart, 600, 400, info);
			  } catch (Exception e) {
			  		out.println(e);
			  }
%>
<html>
  <head>
  <meta http-equiv="Content-Type" 
  content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
   <img src="images/piechart.jpg" width="472" height="300"/>
  </body>
</html> 
