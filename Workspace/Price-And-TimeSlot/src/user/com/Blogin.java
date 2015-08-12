package user.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;

public class Blogin extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HttpSession session = request.getSession(true);
			String username = request.getParameter("name");
			
			DBConnection db=new DBConnection();
			Connection con;
			Statement st;
			con=db.getConnection();
			st=con.createStatement();
			
			HashMap userMap=new HashMap();
						
			String userID="";
			String sq="select * from userdetails where username='"+username+"'";
			ResultSet rs=st.executeQuery(sq);
			if(rs.next())
			{
				userMap.put(rs.getString(1),rs.getString(2));
				System.out.println("Map--------->"+userMap);
				userID=userMap.get(username).toString();
				session.setAttribute("userID",userID);
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("failure.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
