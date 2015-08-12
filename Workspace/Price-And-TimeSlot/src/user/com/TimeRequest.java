package user.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;
import DataBase.DBServices;

public class TimeRequest extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		try{
		String sttime=request.getParameter("Start");
		String edtime=request.getParameter("End");
		String userid=(String)session.getAttribute("userid");
		String password=(String)session.getAttribute("password");
		
		DBConnection db=new DBConnection();
		Connection con;
		Statement st;
		con=db.getConnection();
		st=con.createStatement();
		ResultSet rs;
		
		Vector v=new Vector();
		String sql="select * from timereq";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			v.add(rs.getString(3));
		}
		
		if(!v.contains(userid))
		{
			DBServices dbs=new DBServices();
			String status=dbs.timeRequest(sttime,edtime,userid);
			
				if(status.equals("success")){
					response.sendRedirect("orgview.jsp");
				}
		}
		else
		{
			response.sendRedirect("TimeFailure.jsp");
		}		
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
