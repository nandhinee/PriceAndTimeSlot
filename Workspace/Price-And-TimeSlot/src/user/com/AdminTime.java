package user.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;
import DataBase.DBServices;

public class AdminTime extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		try{
		String userid=request.getParameter("userid");
		
		DBConnection db=new DBConnection();
		Connection con;
		Statement st;
		con=db.getConnection();
		st=con.createStatement();
		ResultSet rs;
		
		int strt=0,eti=0;
		String sql="select * from timereq where userid='"+userid+"'";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			strt=Integer.parseInt(rs.getString(1));
			eti=Integer.parseInt(rs.getString(2));
		}
		System.out.println("eti---------->"+eti+"------------"+strt);
		int calc=eti-strt;
		
		int mulc=calc*100;
		
		DBServices dbs=new DBServices();
		String status=dbs.adminTimeRequest(userid);
			if(status.equals("success")){
				int bal=0;
				System.out.println("User name---------->"+userid);
				String sq="select * from amountdetails where UserID='"+userid+"'";
				rs=st.executeQuery(sq);
				while(rs.next())
				{
					bal=Integer.parseInt(rs.getString(3));
					System.out.println("bal---------------------------->"+bal);
				}
				bal=bal-mulc;
				System.out.println("al---------------------->"+bal);
				String sqd="update amountdetails set Balance='"+bal+"' where UserID='"+userid+"'";
				st.executeUpdate(sqd);
				System.out.println("Updated");
				
				response.sendRedirect("requestaccept.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}