package user.com;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet implements Inter{

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

		HttpSession session=req.getSession();
		String userid=(String) session.getAttribute("userid");
		System.out.println("......xxxxxxxxxxxxxxx......."+userid);
		vec.remove(userid.trim());
		int size=vec.size();
		session.setAttribute("size", size);
		 System.out.println("......Logout size......."+size);
		//session.removeAttribute("LoggedIn");
		//session.invalidate();
		res.sendRedirect("/Price-And-TimeSlot/");
	}
}