package user.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;
import DataBase.DBServices;

public class Download extends HttpServlet{

		public void doGet(HttpServletRequest request,HttpServletResponse response){
			HttpSession session=request.getSession(true);
			try{
			String fileid=(String) request.getParameter("fileid");
			String userid=(String) session.getAttribute("userid");
			String password=(String) session.getAttribute("password");
			
			DBConnection db=new DBConnection();
			Connection con;
			Statement st;
			con=db.getConnection();
			st=con.createStatement();
			
			Vector vFile=new Vector();
			String sq="select * from fileservice";
			ResultSet rs=st.executeQuery(sq);
			while(rs.next())
			{
				vFile.add(rs.getString(2));
			}
			
			if(vFile.contains(fileid)){
			System.out.println("..xx..."+userid+"..yy..."+fileid);
			
			DBServices dbs=new DBServices();
			String status=dbs.downloadVerify(fileid,userid,password);
			System.out.println("......................................."+status);
			StringTokenizer stk=new StringTokenizer(status,"*");
			String filename=stk.nextToken();
			String serverpath=stk.nextToken();
			System.out.println("...1..."+filename+"...2..."+serverpath);
			
			

				session.setAttribute("filename", filename);
				session.setAttribute("serverpath", serverpath);
				response.sendRedirect("displaydownlod.jsp");
			}else{
				response.sendRedirect("failure.jsp");
			}
			}catch(Exception e){
				e.printStackTrace();
			}			
		}	
}
