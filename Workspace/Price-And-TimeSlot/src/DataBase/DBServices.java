package DataBase;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class DBServices {
	DBConnection dbc;
	public String userDetails(String name,String pass,String address,String phone,String email,String startdate,String enddate,String time,String amt) {
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try{
			PreparedStatement pst=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, "null");
			pst.setString(3, pass);
			pst.setString(4, address);
			pst.setString(5, phone);
			pst.setString(6, email);
			pst.execute();
			StringTokenizer stk=new StringTokenizer(time,"*");
			String one=stk.nextToken();
			String totalsize=stk.nextToken();
			String price=stk.nextToken();
			StringTokenizer stk1=new StringTokenizer(one,"-");
			String starttime=stk1.nextToken();
			String endtime=stk1.nextToken();
			PreparedStatement pst1=con.prepareStatement("insert into adminverify values(?,?,?,?,?,?,?,?,?,?,?)");
			pst1.setString(1, name);
			pst1.setString(2, pass);
			pst1.setString(3, startdate);
			pst1.setString(4, enddate);
			pst1.setString(5, starttime);
			pst1.setString(6, endtime);
			pst1.setString(7, totalsize);
			pst1.setString(8, price);
			pst1.setString(9, "status");
			pst1.setString(10, amt);
			pst1.setString(11, "null");
			pst1.execute();
			status="success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String bankVerify(String bankname,String accno, String cvvno, String name,String pass)
	{
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from bankdetails where bankname='"+bankname+"' and accno='"+accno+"' and cvvno='"+cvvno+"'");
			boolean boo=rs.next();
			if(boo)
			{
				Statement st1=con.createStatement();
				st1.executeUpdate("update adminverify set status='paid' where username='"+name+"' and password='"+pass+"'");
				
				String sql="select username,password,price,status from adminverify where username='"+name+"' and password='"+pass+"'";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs1=pst.executeQuery();
				while (rs1.next())
				{
				 String name1=rs1.getString(1).toString().trim();
				 String pass1=rs1.getString(2).toString().trim();
				 String price1=rs1.getString(3).toString().trim();
				 String status1=rs1.getString(4).toString().trim();
				 
				 System.out.println("vinoth testing--------"+name1);
				 
				 PreparedStatement psaec=con.prepareStatement("insert into accept values(?,?,?,?)");
				 psaec.setString(1, name1);
				 psaec.setString(2, pass1);
				 psaec.setString(3, price1);
				 psaec.setString(4, status1);
				 psaec.execute();
				}								
				status="success";
			}else{
				status="failure";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String adminAccept(String username,String password)
	{
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		Random rd=new Random();
		String userid="cloud"+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10);
		try
		{
			Statement st1=con.createStatement();
			st1.executeUpdate("update userdetails set userid='"+userid+"' where username='"+username+"' and password='"+password+"'");
			  Statement st = con.createStatement();
			  String sql = "DELETE FROM accept WHERE username = '"+username+"' and password='"+password+"'";
			  int delete = st.executeUpdate(sql);
			  if(delete == 1){
			  status="success";
			  }
			  else{
			  status="failure";
			  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String loginService(String userid,String password)
	{
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from userdetails where userid='"+userid+"' and password='"+password+"'");
			boolean boo=rs.next();
			if(boo)
			{
				status="success";
			}else{
				status="failure";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String validateService(String userid,String password)
	{
		
		String status="false";String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username from userdetails where userid='"+userid.trim()+"' and password='"+password.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			System.out.println("Check true or false......"+check);
			while (check)
			{
			 name1=rs1.getString(1).toString().trim();
			 status="true";
			 break;
			}
			if(status.equalsIgnoreCase("true")) {
				String sql1="select startdate ,enddate ,starttime,endtime from adminverify where username='"+name1+"' and password='"+password+"'";
				PreparedStatement pstr=con.prepareStatement(sql1);
				ResultSet rst=pstr.executeQuery();
				while (rst.next())
				{
					status=rst.getString(1).toString().trim()+"*"+rst.getString(2).toString().trim()+"*"+rst.getString(3).toString().trim()+"*"+rst.getString(4).toString().trim();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String fileService(String filnam,String key,String fileName,String name,String pass,String folderName,String filesize,String url){
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try{
			PreparedStatement pst=con.prepareStatement("insert into fileservice values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, filnam);
			pst.setString(2, key);
			pst.setString(3, fileName);
			pst.setString(4, name);
			pst.setString(5, pass);
			pst.setString(6, folderName);
			pst.setString(7, filesize);
			pst.setString(8, url);
			pst.setString(9, "null");
			pst.execute();
			status="success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public ArrayList store(String userid,String password)
	{
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		ArrayList<String> list= new ArrayList<String>();
		try
		{
			String sql1="select filepath from fileservice where userid='"+userid+"' and password='"+password+"'";
			PreparedStatement pstr=con.prepareStatement(sql1);
			ResultSet rst=pstr.executeQuery();
			while (rst.next()) {
			    list.add(rst.getString(1));
			}   
			//StringBuffer arrval=new StringBuffer();
			//arrval.append(list);
			
			System.out.println("....check11..."+list);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public String storeValue(String userid,String password)
	{
		
		String status="false";String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username from userdetails where userid='"+userid.trim()+"' and password='"+password.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			while (check)
			{
			 name1=rs1.getString(1).toString().trim();
			 status="true";
			 break;
			}
			if(status.equalsIgnoreCase("true")) {
				String sql1="select totalsize from adminverify where username='"+name1+"' and password='"+password+"'";
				PreparedStatement pstr=con.prepareStatement(sql1);
				ResultSet rst=pstr.executeQuery();
				while (rst.next())
				{
					status=rst.getString(1).toString().trim();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	//..................................................
	public String downloadVerify(String fileid,String userid,String password) {
		String status = "";
		dbc = DBConnection.getInstance();
		Connection con = dbc.getConnection();
		try {
			String sql="select filename , serverpath from fileservice where fileid='"+fileid+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("....value...."+ (rs.getString(1).toString().trim()) + "*"+ (rs.getString(2).toString().trim()));
				status = rs.getString(1).toString().trim()+"*"+rs.getString(2).toString().trim();
				System.out.println("...cutting..." + status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	/*public String downloadVerify(String fileid,String userid,String password)
	{
		System.out.println("......came......");
		String status="false";
		//String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select filename , serverpath from fileservice where fileid='"+fileid+"' and userid='"+userid.trim()+"' and password='"+password.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			boolean boo=rs1.next();
			
			while (rs1.next())
			{
				System.out.println("..the.."+rs1.getString(1).toString().trim()+"*"+rs1.getString(2).toString().trim());
				status=rs1.getString(1).toString().trim()+"*"+rs1.getString(2).toString().trim();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}*/
	public String ajxverify(String userid,String password)
	{
		
		String status="false";
		String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username from userdetails where userid='"+userid.trim()+"' and password='"+password.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			while (check)
			{
			 name1=rs1.getString(1).toString().trim();
			 status="true";
			 break;
			}
			if(status.equalsIgnoreCase("true")) {
				String sql1="select startdate,enddate,starttime,endtime,risk from adminverify where username='"+name1+"' and password='"+password+"'";
				PreparedStatement pstr=con.prepareStatement(sql1);
				ResultSet rst=pstr.executeQuery();
				while (rst.next())
				{
					status=rst.getString(1).toString().trim()+"&"+rst.getString(2).toString().trim()+"&"+rst.getString(3).toString().trim()+"&"+rst.getString(4).toString().trim()+"&"+rst.getString(5).toString().trim();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String change(String userid)
	{
		
		String status="false";
		String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username,password from userdetails where userid='"+userid.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			System.out.println("Check true or false......"+check);
			while (check)
			{
			 name1=rs1.getString(1).toString().trim()+"&"+rs1.getString(2).toString().trim();
			 status="true";
			 break;
			}
			StringTokenizer stk=new StringTokenizer(name1 ,"&");
			String name=stk.nextToken();
			String password=stk.nextToken();
			if(status.equalsIgnoreCase("true")) {
				Statement st1=con.createStatement();
				st1.executeUpdate("update adminverify set risk='change' where username='"+name+"' and password='"+password+"'");
				status="success";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String ajaxUpdate1(String currentdate,String returndate,String userid,String password)
	{
		
		String status="false";
		String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username from userdetails where userid='"+userid.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			System.out.println("Check true or false......"+check);
			while (check)
			{
			 name1=rs1.getString(1).toString().trim();
			 status="true";
			 break;
			}			
			if(status.equalsIgnoreCase("true")) {
				Statement st1=con.createStatement();
				st1.executeUpdate("update adminverify set startdate='"+currentdate+"', enddate='"+returndate+"', risk='null' where username='"+name1+"' and password='"+password+"'");
				status="success";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String ajaxUpdate2(String userid,String password)
	{
		
		String status="false";
		String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username from userdetails where userid='"+userid.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs1=pst.executeQuery();
			Boolean check = rs1.next();
			System.out.println("Check true or false......"+check);
			while (check)
			{
			 name1=rs1.getString(1).toString().trim();
			 status="true";
			 break;
			}			
			if(status.equalsIgnoreCase("true")) {
				Statement st1=con.createStatement();
				st1.executeUpdate("update adminverify set risk='null' where username='"+name1+"' and password='"+password+"'");
				status="success";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String timeRequest(String sttime,String edtime,String userid)
	{
		String status="";
		
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			PreparedStatement pst=con.prepareStatement("insert into timereq values(?,?,?)");
			pst.setString(1, sttime);
			pst.setString(2, edtime);
			pst.setString(3, userid);
			pst.execute();
			status="success";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String cloudRequest(String userid,String password)
	{
		
		String status="";
		
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			PreparedStatement pst=con.prepareStatement("insert into cloudreq values(?,?,?)");
			pst.setString(1, userid);
			pst.setString(2, "pending...");
			pst.setString(3, "url");
			pst.execute();
			status="success";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String adminTimeRequest(String userid)
	{
		String status="";
		String stime = "",etime="",username = "",password="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select username,password,starttime,endtime  from userdetails inner join timereq on userdetails.userid='"+userid+"'";
			PreparedStatement pstr=con.prepareStatement(sql);
			ResultSet rs1=pstr.executeQuery();
			Boolean check = rs1.next();
			System.out.println("Check true or false......"+check);
			while (check)
			{
				username=rs1.getString(1).toString().trim();
				password=rs1.getString(2).toString().trim();
				stime=rs1.getString(3).toString().trim();
				etime=rs1.getString(4).toString().trim();
				
				status="true";
				 break;
				}			
				if(status.equalsIgnoreCase("true")) {
					Statement st1=con.createStatement();
					st1.executeUpdate("update adminverify set starttime='"+stime+"',endtime='"+etime+"' where username='"+username+"' and password='"+password+"'");
					st1.executeUpdate("delete from timereq where userid='"+userid+"'");					
					status="success";
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String adminRedirect(String userid,String url)
	{
		
		String status="";
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			Statement st1=con.createStatement();
			st1.executeUpdate("update cloudreq set status='Accept',urllocation='"+url+"' where userid='"+userid+"'");
			status="success";
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public String accessCloudValidation(String userid)
	{
		
		String status="false";
		String name1 = null;
		dbc=DBConnection.getInstance();
		Connection con=dbc.getConnection();
		try
		{
			String sql="select urllocation from cloudreq where userid='"+userid.trim()+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery();
			while (rst.next())
			{
				status=rst.getString(1).toString().trim();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
}


