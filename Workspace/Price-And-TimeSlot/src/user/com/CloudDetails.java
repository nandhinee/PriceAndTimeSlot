package user.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class CloudDetails extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		String startdate=request.getParameter("start");
		String enddate=request.getParameter("end");
		String pack=request.getParameter("time");
		System.out.println("........................"+pack);
		session.setAttribute("startdate", startdate);
		session.setAttribute("enddate", enddate);
		session.setAttribute("pack", pack);
		if(!startdate.equals("")){
			response.sendRedirect("confirm.jsp");	
			
		}
	}
}
