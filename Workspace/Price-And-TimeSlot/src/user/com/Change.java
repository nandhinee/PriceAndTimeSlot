package user.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DBServices;

public class Change extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
		String userid=request.getParameter("userid");
		DBServices dbs=new DBServices();
		String status=dbs.change(userid);
		if(status.equals("success")){
			response.sendRedirect("currentuser.jsp");
		}else{
			response.sendRedirect("change.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
