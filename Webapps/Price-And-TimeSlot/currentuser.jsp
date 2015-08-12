
<%@page import="java.util.Vector"%>
<%@page import="java.util.StringTokenizer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ page import="java.awt.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="user.com.Duplicate"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Admin</title>
		<link href="css/styles.css" rel="stylesheet" type="text/css" />
	</head>
	<%
		Vector ect = new Vector();

		Duplicate dup = new Duplicate();
		ect = dup.getVector();
		System.out.println("...xxx...." + ect);
	%>
	<body>
		<form name="" action="./adminlogin" method="get"
			enctype="multipart/form-data">
			<div id="mainbody">
				<div id="topheader">
					<a href="#"><img src="images/logo.jpg" title="Business Company"
							alt="Business Company" width="194" height="47" border="0" />
					</a>
					<ul style="background-color: rgb(0, 255, 0);">
						<li class="Home">
							<font size="4"><a href="firstpage.jsp">&nbsp; Home</a>
							</font>
						</li>
						<li class="Approve">
							<font size="4"><a href="requestaccept.jsp">&nbsp;&nbsp;&nbsp;&nbsp;
									Request &nbsp; &nbsp; &nbsp; <br />
							</a>
							</font>
						</li>
						<li class="">
							<font size="4"><a href="admin1.jsp">UserDetails</a>
							</font>
						</li>
						<li class="">
							<font size="4"><a href="Map.jsp">&nbsp;&nbsp;&nbsp;
									RiskMap</a>
							</font>
						</li>
						<li class="">
							<font size="4"><a href="currentuser.jsp">&nbsp; &nbsp;
									OnlineUser</a>
							</font>
						</li>
					</ul>
				</div>
				<div id="topback">
					<h2>
						welcome
					</h2>
					<p>
						<span>LOREM IPSUM DOLOR</span>
						<br />
						Dolores et ea consetetur sadi pscing elit consetetur pscing elitr,
						sed diam nonumy consetetur sadi pscing elit consetetur pscing
						elitr, sed diam nonumy consetetur sadi lorem sed lorem ipsum
						consetetur pscing consetetur lorem ipsum
					</p>
					<ul>
						<li>
							<a href="#">Dolores et ea consetetur sadi </a>
						</li>
						<li>
							<a href="#">pscing elit consetetur pscing elitr,</a>
						</li>
						<li>
							<a href="#">sed diam nonumy consetetur sadi </a>
						</li>
						<li>
							<a href="#">pscing elit consetetur pscing</a>
						</li>
						<li>
							<a href="#">elitr, sed diam nonumy consetetur </a>
						</li>
					</ul>
					<ul class="ask">
						<li>
							<a href="#" title="Enter"></a>
						</li>
					</ul>
				</div>
				<div id="bodypan">
					<div id="leftpan" style="width: 755px; height: 379px">
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</p>
						<p>
							&nbsp;
						</p>
						<p>
							&nbsp;
						</p>
						<p>
							&nbsp;
						</p>
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<table height="105" width="437" align="center">
								<tr>
									<td align="center" height="50">
										<FONT color="#0000ff" size="4">User ID</FONT>
									</td>
								</tr>

								<tr>
									<br />
									<br />
								</tr>
								<tr></tr>
								<%
									String s1 = "";
									//String s2="";
									for (int i = 0; i < ect.size(); i++) {
										String st = ect.get(i).toString();
										System.out.println("...test..." + st);
										st = st.replace("[", " ");
										st = st.replace("]", " ");

										StringTokenizer str = new StringTokenizer(st, ",");
								%>

								<%
									while (str.hasMoreTokens()) {
											s1 = str.nextToken();
								%>
								<tr align="center">
									<td align="center" width="235" height="30">
										<font color="Black" size="4"><%=s1%></font>
										<br />
									</td>
								</tr>
								<%
									}
								%>
								<%
									}
								%>
								<tr align="center">
									<td align="center" width="235" height="30">
										<font size="4"><a href="change.jsp">...Next...</a>
										</font>
										<br />
									</td>
								</tr>
							</table>
					</div>
					<div id="footer">
						<p>
							<a href="#">HOME</a> |
							<a href="#">ABOUT US</a> |
							<a href="#">SERVICES</a> |
							<a href="#">PARTNERS</a> |
							<a href="#">SUPPORT</a> |
							<a href="#">NEWS &amp; EVENTS</a> |
							<a href="#">CONTACTS</a>
							<br />
							Copyright &copy; Your Company Name. Designed by
							<a href="http://www.freecsstemplates.com" target="_blank">FreeCSSTemplates.com</a>
						</p>
						<img src="images/callus.jpg" alt="" width="123" height="37" />
					</div>
				</div>
		</form>
	</body>
</html>