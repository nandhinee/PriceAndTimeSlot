package user.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBConnection;
import DataBase.DBServices;

import com.mysql.jdbc.Connection;

public class DisplayDate extends HttpServlet implements Inter{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		boolean aware = false;
		PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        HttpSession session=request.getSession(true);
        String userid=(String) session.getAttribute("userid");
        String password=(String) session.getAttribute("password");
        System.out.println("..username.."+userid);
        System.out.println("..password.."+password);
        try{
        	DBServices dbs=new DBServices();
        	String status=dbs.ajxverify(userid,password);
        	System.out.println("..stat.."+status);
        	StringTokenizer stkr=new StringTokenizer(status ,"&");
        	String stdate=stkr.nextToken();
        	String eddate=stkr.nextToken();
        	String sttime=stkr.nextToken();
        	String edtime=stkr.nextToken();
        	String risk=stkr.nextToken();
        	//........................................................
        	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    		Calendar c = Calendar.getInstance();
    		String date1 = sdf.format(c.getTime());
    		
    		c.setTime(sdf.parse(date1));
    		c.add(Calendar.DATE, 1); 
    		String nextday = sdf.format(c.getTime());
    		c.setTime(sdf.parse(eddate));
    		c.add(Calendar.DATE, 4);  // number of days to add
    		String returndate = sdf.format(c.getTime());
    		System.out.println("...now date..."+nextday);
    		System.out.println("...plus four days..."+returndate);
    	
    		//.........................................................
    		
        if(risk.equals("change")) {
        	System.out.println(".......check......");
        	
	        sb.append((new StringBuilder("<employee><date>")).append(returndate).append("</date>").append("<cdate>").append(nextday).append("</cdate>").append("</employee>").toString());
	      
        }
        else{
        	System.out.println(".......risk....null..");
        	 sb.append((new StringBuilder("<employee><date>")).append(risk).append("</date>").append("<cdate>").append(risk).append("</cdate>").append("</employee>").toString());
        }
        
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write((new StringBuilder("<employees>")).append(sb.toString()).append("</employees>").toString());
        out.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}
}
