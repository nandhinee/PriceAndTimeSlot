package user.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBServices;

public class AccessCloudValidation extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		try{
			String userid=(String)session.getAttribute("userid");
		
			DBServices dbs=new DBServices();
			String status=dbs.accessCloudValidation(userid);
			System.out.println("............................................."+status);
		
			if(status.equals("url")){
				response.sendRedirect("failure.jsp");
			}else if(status.equals("false")){
				response.sendRedirect("failure.jsp");
			}else{
				session.setAttribute("url", status);
				response.sendRedirect("beforecloud.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}