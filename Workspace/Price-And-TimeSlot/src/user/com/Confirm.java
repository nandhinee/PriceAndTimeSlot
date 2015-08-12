package user.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;
import DataBase.DBServices;

 public class Confirm extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HashMap hmAmo=new HashMap(); 
			
		HttpSession session=request.getSession(true);
		String bankname=request.getParameter("bank");
		String accno=request.getParameter("accno");
		String cvvno=request.getParameter("cvvno");
		
		String name=session.getAttribute("name").toString();
		String pass=session.getAttribute("pass").toString();
		String address=session.getAttribute("address").toString();
		String phone=session.getAttribute("phone").toString();
		String email=session.getAttribute("email").toString();
		
		String startdate=session.getAttribute("startdate").toString();
		String enddate=session.getAttribute("enddate").toString();
		String pack=session.getAttribute("pack").toString();
		System.out.println(".....enddate....."+enddate);
		System.out.println(".....pack....."+pack);
		
		DBConnection db=new DBConnection();
		Connection con;
		Statement st;
		con=db.getConnection();
		st=con.createStatement();
		
		String time = "",redAmou="";
		
		
		if(pack.equals("Time-1")){
			
			time= "9-10*55 MB*150";
			
		}else if(pack.equals("Time-2")){
			
			time= "10-11*56 MB*200";
			
		}else if(pack.equals("Time-3")){
			
			time= "14-15*54 MB*100";
			
		}else if(pack.equals("Time-4")){
			time= "17-18*58 MB*500";
		}
		
		Vector vBank=new Vector();
		String sql="select * from bankdetails";
		ResultSet rs1=st.executeQuery(sql);
		while(rs1.next())
		{
			vBank.add(rs1.getString(1));
			vBank.add(rs1.getString(2));
			vBank.add(rs1.getString(3));
			vBank.add(rs1.getString(4));
		}
		String amt="";
		System.out.println("bank--"+bankname+"---"+accno);
		System.out.println("vvbb--"+vBank);
		if(vBank.contains(bankname)&&vBank.contains(accno)&&vBank.contains(cvvno))
		{
			String sql1="select * from bankdetails where bankname='"+bankname+"' and accno='"+accno+"' and cvvno='"+cvvno+"'";
			ResultSet rste=st.executeQuery(sql1);
			while(rste.next())
			{
				amt=rste.getString(4);
			}
		DBServices dbs=new DBServices();
		String status=dbs.userDetails(name,pass,address,phone,email,startdate,enddate,time,amt);
		
		if(status.equals("success")){
			
			String status1=dbs.bankVerify(bankname,accno,cvvno,name,pass);
			if(status1.equals("success")){
				
				response.sendRedirect("userfirstpage.jsp");
			}
		}
		}
		else
		{
			response.sendRedirect("bankfail.jsp");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

