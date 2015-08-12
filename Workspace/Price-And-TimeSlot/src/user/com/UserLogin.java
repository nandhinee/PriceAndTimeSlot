package user.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DBServices;

public class UserLogin extends HttpServlet implements Inter {

	// int check;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		String userid = request.getParameter("name");
		String password = request.getParameter("pass");
		System.out.println("....pass......" + password);
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);
		try {
			DBServices dbs = new DBServices();
			String status = dbs.loginService(userid, password);
			System.out.println("....1...." + status);

			if (status.equals("success")){
				String uservalidate = dbs.validateService(userid, password);
				StringTokenizer str = new StringTokenizer(uservalidate, "*");
				String str_date = str.nextToken();
				String end_date = str.nextToken();
				String st_tim = str.nextToken();
				String ed_tim = str.nextToken();
				System.out.println("....6..." + end_date);
				DateFormat dateFormat = new SimpleDateFormat(
						"dd-MM-yyyy HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				StringTokenizer st = new StringTokenizer(dateFormat
						.format(date), " ");
				String currentDate = st.nextToken().trim();
				String time = st.nextToken().trim();
				System.out.println("....." + currentDate + "......." + time);
				StringTokenizer tim = new StringTokenizer(time, ":");
				String val = tim.nextToken().trim();
				System.out.println("....." + val);
				int hour = Integer.parseInt(val);
				int s_time = Integer.parseInt(st_tim);
				int e_time = Integer.parseInt(ed_tim);

				System.out.println("..1.." + tim.nextToken().trim());
				// .....................................................................

				ArrayList<Date> dates = new ArrayList<Date>();
				ArrayList<String> dates1 = new ArrayList<String>();

				DateFormat formatter;

				formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date startDate;

				startDate = (Date) formatter.parse(str_date);
				Date endDate = (Date) formatter.parse(end_date);
				long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
				long endTime = endDate.getTime(); // create your endtime here,
													// possibly using Calendar
													// or Date
				long curTime = startDate.getTime();
				while (curTime <= endTime) {
					dates.add(new Date(curTime));
					curTime += interval;
				}
				for (int i = 0; i < dates.size(); i++) {
					Date lDate = (Date) dates.get(i);
					String ds = formatter.format(lDate);
					dates1.add(ds);
					System.out.println(" Date is ..." + ds);
				}
				if (dates1.contains(currentDate)) {
					if (hour >= s_time && hour < e_time) {
						System.out.println("......hai.....");
						response.sendRedirect("orgview.jsp");
					} else {
						System.out.println("....failure.....");
						response.sendRedirect("failure.jsp");
					}
				} else {
					System.out.println("...invalid....");
					response.sendRedirect("failure.jsp");
				}
				System.out.println("....checking count.....");
				Login(userid);
				int size = vec.size();
				System.out.println("..check size..." + size);
				session.setAttribute("size", size);
				// .....................................................................
			} else {
				response.sendRedirect("failure.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void Login(String id) {
		if (vec.contains(id)) {

		} else {
			vec.add(id);
		}
	}
}
