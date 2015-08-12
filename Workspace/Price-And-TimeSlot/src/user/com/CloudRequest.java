package user.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBServices;

public class CloudRequest extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		try{
		String userid=(String)session.getAttribute("userid");
		String password=(String)session.getAttribute("password");
		
		DBServices dbs=new DBServices();
		String status=dbs.cloudRequest(userid,password);
		
			if(status.equals("success")){
				response.sendRedirect("orgview.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}