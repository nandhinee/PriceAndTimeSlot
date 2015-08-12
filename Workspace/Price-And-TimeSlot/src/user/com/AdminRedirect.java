package user.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBServices;

public class AdminRedirect extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		try{
		String userid=request.getParameter("userid");
		String url=request.getParameter("url");
		
		DBServices dbs=new DBServices();
		String status=dbs.adminRedirect(userid,url);
		
			if(status.equals("success")){
				response.sendRedirect("requestaccept.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}