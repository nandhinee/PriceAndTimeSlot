package user.com;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadLink extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		String location=request.getParameter("link");
		try {
			System.out.println(".....down check"+location);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment;filename="+location.substring(location.lastIndexOf("\\")+1));
			System.out.println("...last check..."+location.substring(location.lastIndexOf("\\")+1));
			ServletOutputStream out = response.getOutputStream();
			System.out.println("------DownloadFileAction-------"+location);
			URL hp = new URL(location);
			URLConnection hpCon = hp.openConnection();
			int len = hpCon.getContentLength();
			if (len > 0) {
			InputStream input = hpCon.getInputStream();
			int i = len;
			int c;
			while (((c = input.read()) != -1) && (i > 0)) {
			out.write((char)c);
			}
			input.close();
			out.flush();
	    	out.close();
			} else {
			System.out.println("No Content Available");
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
