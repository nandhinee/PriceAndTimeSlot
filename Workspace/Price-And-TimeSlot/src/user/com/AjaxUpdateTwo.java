package user.com;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBServices;

public class AjaxUpdateTwo extends HttpServlet{

	public void doGet(HttpServletRequest request , HttpServletResponse response){
		
		HttpSession session=request.getSession(true);
		String userid=(String) session.getAttribute("userid");
        String password=(String) session.getAttribute("password");
        session.setAttribute(userid, "userid");
        session.setAttribute(password,"password");
        System.out.println("............."+userid);
        System.out.println("............."+password);
        DBServices dbs=new DBServices();
        String status=dbs.ajaxUpdate2(userid, password);
        StringBuffer sb = new StringBuffer();
        try{
			PrintWriter out = response.getWriter();
			System.out.println("...AjaxUpdateTwo...."+status);
			if(status.equals("success")){
				sb.append((new StringBuilder("<employee><date>")).append("successfullycancel").append("</date>").append("</employee>").toString());
			}
			else{
				sb.append((new StringBuilder("<employee><date>")).append("nocancel").append("</date>").append("</employee>").toString());
			}
			
		       response.setContentType("text/xml");
		        response.setHeader("Cache-Control", "no-cache");
		        response.getWriter().write((new StringBuilder("<employees>")).append(sb.toString()).append("</employees>").toString());
		        out.close();
				
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
}
