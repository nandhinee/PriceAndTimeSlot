package user.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class PersonalDetails extends HttpServlet {
	 RequestDispatcher redirect;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		int user=name.length();
		int pass = password.length();
		int phoneno1 = phone.length();
		
		collectionsFramework coll=new collectionsFramework();
		if(coll.get())
		{
		if(user<3)
		{
        	System.out.println("user name length more than 3 ");
			request.setAttribute("Alert", "UserName Field Required atleast four character");
			redirect= request.getRequestDispatcher("register.jsp");
			redirect.forward(request,response);
			//response.sendRedirect("register.jsp");
		}
		else
		if(pass < 4)
		{
			System.out.println("pass not correct");
			request.setAttribute("Alert", "Password Field Required atleast four character");
			redirect= request.getRequestDispatcher("register.jsp");
			redirect.forward(request,response);
		}
		else
		if((phoneno1<10)||(phoneno1>10))
		{
			System.out.println("phone not correct");
			request.setAttribute("Alert", " Enter valid phone number Format");
			redirect= request.getRequestDispatcher("register.jsp");
			redirect.forward(request,response);
		}
		else
		if(!email.contains("@"))
	    {
			System.out.println("email not correct");
			session.setAttribute("Alert", "Enter the valid emailid");
			redirect= request.getRequestDispatcher("register.jsp");
			redirect.forward(request,response);
	    }
		else
		if(!email.contains("."))
	    {
			System.out.println("email not correct");
			session.setAttribute("Alert", "Enter the valid emailid");
			redirect= request.getRequestDispatcher("register.jsp");
			redirect.forward(request,response);
	    }
		else
		{
			session.setAttribute("name", name);
			session.setAttribute("pass", password);
			session.setAttribute("address", address);
			session.setAttribute("phone", phone);
			session.setAttribute("email", email);
			if(!name.equals("")){
				response.sendRedirect("register1.jsp");			
			}
		}
		}
	}
}
