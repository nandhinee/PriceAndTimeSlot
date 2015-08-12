package user.com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DBConnection;
import DataBase.DBServices;

public class AdminAccept extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		try {
			DBConnection db=new DBConnection();
			Connection con;
			Statement st;
			con=db.getConnection();
			st=con.createStatement();
		DBServices dbs=new DBServices();
		String status=dbs.adminAccept(name,password);
				if(status.equals("success")){
						
						String id="",phone="";
						String sql="select * from userdetails where username='"+name+"'";
						ResultSet rs=st.executeQuery(sql);
						while(rs.next())
						{
							id=rs.getString(2).toString();
							phone=rs.getString(5).toString();
						}
						
						int amount=0,reduamt=0,calcAm=0;
						
						String sql1="select * from adminverify where username='"+name+"'";
						ResultSet rs1=st.executeQuery(sql1);
						while(rs1.next())
						{
							amount=Integer.parseInt(rs1.getString(10));
							reduamt=Integer.parseInt(rs1.getString(8));
						}
						
						calcAm=amount-reduamt;
						
						String userId="";
						String sql2="select * from userdetails where username='"+name+"'";
						ResultSet rs2=st.executeQuery(sql2);
						while(rs2.next())
						{
							userId=rs2.getString(2).toString();
						}
						
						String sqll="insert into amountdetails (UserID,Amount,Balance) values ('"+userId+"','"+String.valueOf(amount)+"','"+String.valueOf(calcAm)+"')";
						st.executeUpdate(sqll);
						String mess="Registration done Successfully by Price and Time Slot Management"+"\n"+"Your ID - "+id;
						System.out.println("Message---->"+mess);
						sendsms(mess,phone);
						response.sendRedirect("approve.jsp");
				}else{
					    response.sendRedirect("invalid.jsp");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendsms(String mess,String phone)
	{
		try
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream("sms.properties"));
			String smsUrl = prop.getProperty("smsurl");
			System.out.println("sms->"+smsUrl);
			int c;
			URL url = new URL(smsUrl+"&msg="+mess+"&phone="+phone);
			//URL url = new URL("http://ubaid.tk/sms/sms.aspx?uid="+user+"&pwd="+pass+"&msg="+mess+"&phone="+number+"&provider=way2sms");
			URI uri = new URI(url.getProtocol(), url.getAuthority(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
			URL hp=new URL(uri.toString());
			URLConnection hpCon = hp.openConnection();
			System.out.println("Date: " + new Date(hpCon.getDate()));
			System.out.println("Content-Type: " +hpCon.getContentType());
			System.out.println("Expires: " + hpCon.getExpiration());
			System.out.println("Last-Modified: " +new Date(hpCon.getLastModified()));
			int len = hpCon.getContentLength();
			System.out.println("Content-Length: " + len);
			if (len > 0)
			{
				System.out.println("=== Content ===");
				InputStream input = hpCon.getInputStream();
				int ii = len;
				while (((c = input.read()) != -1) && (ii > 0))
				{
					System.out.print((char) c);
				}
				input.close();
				System.out.println("Msg Sent Successfully........");
			}
			else
			{
				System.out.println("No Content Available");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
