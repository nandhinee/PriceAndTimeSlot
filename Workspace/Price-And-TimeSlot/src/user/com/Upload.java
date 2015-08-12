package user.com;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DataBase.DBConnection;
import DataBase.DBServices;


public class Upload extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private HashSet images=new HashSet();
	private HashSet videos=new HashSet(); 
	private HashSet text=new HashSet();
	public Upload()
	{
		images.add("image/jpeg");
		images.add("image/bmp");
		images.add("image/x-windows-bmp");
		images.add("image/gif");
		images.add("image/jpeg");
		images.add("image/pjpeg");
		images.add("image/png");
		images.add("image/jpg");
		images.add("image/x-png");
		
		videos.add("video/3gpp");
		videos.add("video/avi");
		videos.add("video/mpeg");
		videos.add("video/mpg");
		videos.add("video/flv");
		videos.add("video/mp4");
		
		text.add("text/html");
		text.add("application/msword");
		text.add("text/plain");
		text.add("text/x-java-source");
		text.add("application/octet-stream");
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try
		{
			String chooserad="";
			DBConnection db=new DBConnection();
			Connection con;
			Statement st;
			con=db.getConnection();
			st=con.createStatement();
			
			HttpSession session = request.getSession(true);
			String userid=(String) session.getAttribute("userid");
			String password=(String)session.getAttribute("password");
			System.out.println("..........."+userid);
			System.out.println("..........."+password);
			FileItem item=null;
			String file="";
			String fileName="";
			response.setContentType("text/html");
			boolean statusCheck = false;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("//////////"+isMultipart);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			java.util.List items = upload.parseRequest(request);
			int i=1;
			String tempo = "";
			File cfile=null;
			//String temp = "webapps/HASBE-Hierarchical/tempfile";
			Iterator iter = ((List) items).iterator();
			//Iterator iter = items.iterator();
			while (iter.hasNext())
			{
				item = (FileItem) iter.next();	
				System.out.println("hhhhhhhhhhhhhhhhhhhh---------"+item.getContentType());
				if (item.isFormField())
				{
					chooserad=item.getString();
					if(!chooserad.equals("submit"))
					{
						String insS="update fileservice set filetype='"+chooserad+"' where filename='"+new File(fileName).getName().toString()+"'";
						st.executeUpdate(insS);
					}
				}
				else
				{
					//fileName = item.getName().toString().trim();
					 cfile=new File(item.getName());
					 System.out.println("iiiiiiiiiiiiiiiiiiiiiii---------"+item.getContentType());
					   InputStream inputStream = null;
					   OutputStream outputStream = null;
					   if (item.getSize() > 0)
				   		{
						  String folderName="/";
						  if(images.contains(item.getContentType())){
							  folderName="image";
						  }else if(videos.contains(item.getContentType())){
							  folderName="videos";
						  }else if(text.contains(item.getContentType())){
							  folderName="text";
						  }
					  fileName = getServletContext().getRealPath("/").replace("\\", "/") +folderName+"/"+cfile.getName();
					  System.out.println("zzzzzzzzzz"+fileName);
					  //.....................................................................................
					  DBServices dbs=new DBServices();
					  
					  ArrayList stat=(ArrayList)dbs.store(userid,password);
					  double total = 0;
					  System.out.println("...check...."+stat);
					  Vector vec = new Vector();
					  for(int a=0;a<stat.size();a++){
						  tempo = stat.get(a).toString().trim();
						  File file1 = new File(tempo); 
							double filesize = file1.length();
							System.out.println("...1...."+filesize);
							double test = (double)filesize/(1024*1024);
							System.out.println("...test...."+test);
							vec.add(test);              
						}
					  System.out.println("...2...."+vec);
					  double temp =0;
						for(int j=0 ;j<vec.size();j++){
							temp =(Double)vec.get(j);
							total=total+temp;
						}
						System.out.println("...3...."+total);
						System.out.println(userid);
						System.out.println(password);
						String value=dbs.storeValue(userid,password);
						System.out.println(".....valueeeeee....."+value);
						StringTokenizer stok=new StringTokenizer(value ," ");
						String val=stok.nextToken();
						int val1=Integer.parseInt(val);
						System.out.println("...4....val1.."+val1);
						
								if(total<=val1){
										System.out.println("....yes.....");
										 File tosave=new File(fileName);
										 System.out.println("....own check...."+cfile.getName());
										 file=tosave.getAbsolutePath();
										 item.write(tosave);
										  System.out.println("....item...."+item);
										  
									  String originalfilename=cfile.getName();
									  long size=item.getSize();
									  int ch=0;
									  while(size>1024){
										  size/=1024;
										  ch++;
										}
									  String endDesc="B";
									  if(ch==1)
										  endDesc="KB";
									  else if (ch==2) {
										  endDesc="MB";
									  }else if(ch==3)
										  endDesc="GB";
									  String filesize = String.valueOf(size)+endDesc;
									  System.out.println("Size of File is: "+ filesize );
									  String ipadd=InetAddress.getLocalHost().getHostAddress();
									  System.out.println("ip: "+ ipadd );
									  String port=String.valueOf(request.getServerPort());
									  String proj=request.getContextPath();
									  String url="http://"+ipadd+":"+port+proj+"/"+folderName+"/"+originalfilename;
									  System.out.println("....1..."+url);
									  Random rd= new Random();
									  String key="fileid"+rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10);
									  System.out.println("......2........"+fileName);
									  System.out.println("......3........"+key);
									  
									  		String str=dbs.fileService(cfile.getName(),key,fileName,userid,password,folderName,filesize,url);
										  if(str.equals("success")){
											  Vector vc=new Vector();
											  String ss1="select * from fileservice where userid='"+userid+"'";
											  ResultSet rsd=st.executeQuery(ss1);
											  while(rsd.next())
											  {
												  vc.add(rsd.getString(7));
											  }
											  System.out.println("------->Vector<----------"+vc);
											  //String sql1="update amountdetails set FreeSize=''"
											  response.sendRedirect("uploadsuccess.jsp");
										  }
						}else{
							System.out.println(".....no........");
							response.sendRedirect("failure.jsp");
						}
					  //.....................................................................................
					}
				}
			}
			 				
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}