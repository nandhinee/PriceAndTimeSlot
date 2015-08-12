package user.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogin  extends HttpServlet{

	/**s
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		collectionsFramework coll=new collectionsFramework();
		if(coll.get())
		{
		try{
			if(name.equals("admin") && pass.equals("admin")){
				response.sendRedirect("admin1.jsp");
			}else{
				response.sendRedirect("invalid.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
	}
}
