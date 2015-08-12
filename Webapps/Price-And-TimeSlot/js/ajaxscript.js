	var isIE;
	var count = 0;
	var completeTable;
	var completeField;
	var autorow;
	var status=false;
	var xmlhttp = false;
	
	function GetXmlHttpObject()
	{
		if (window.XMLHttpRequest) {   
			xmlhttp = new XMLHttpRequest(); 
		}
		else if(window.ActiveXObject) {  
			try {     
				xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  
			} catch (e) {   
				try {     
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");   
				} catch (e) { 
					xmlhttp = false;   
				} 
			}   
		} 
	return xmlhttp; 
	}
	
	function AJAXInteractiondate(url) {
		req=GetXmlHttpObject();
		req.onreadystatechange = processRequestdate;
		req.open("GET", url, true);
		req.send(null);
	}
	//..........................confirm...........................................................
	function AJAXInteractiondateconfirm(url) {
		req=GetXmlHttpObject();
		req.onreadystatechange = processRequestdateconfirm;
		req.open("GET", url, true);
		req.send(null);
	}
	//......................................................................................
	function processRequestdate () {
		if (req.readyState == 4) {
			if (req.status == 200) {
				postProcessdate(req.responseXML);
			}
			 else {
        			alert("Error during AJAX call. Please try again");
     		}
		}
	}
	//..........................confirm...........................................................
	function processRequestdateconfirm () {
		if (req.readyState == 4) {
			if (req.status == 200) {
				postProcessdateconfirm(req.responseXML);
			}
			 else {
        			alert("Error during AJAX call. Please try again");
     		}
		}
	}	
	//......................................................................................
	function initRequest() {
		var url = "DisplayDate?";
		var ajax = new AJAXInteractiondate(url);
	}
	//........................confirm......................................................
	function postProcessdateconfirm(responseXML) {
		var employees = responseXML.getElementsByTagName("employees")[0];
		for (loop1 = 0; loop1 < employees.childNodes.length; loop1++) {
			var employee = employees.childNodes[loop1]
			var date = employee.getElementsByTagName("date")[0];
			appendEmployeedateconfirm(date.childNodes[0].nodeValue); 
		}
	}
	function appendEmployeedateconfirm(val) {
		
			if(val =="successfullyupdate"){
				window.location="/Price-And-TimeSlot/userfirstpage.jsp";
				
			}
			else if(val =="noupdate"){
				alert("Not update");
				setTimeout("initRequest()",5000);
			}
			else if(val =="successfullycancel"){
				
				setTimeout("initRequest()",5000);
			}
			else if(val =="nocancel"){
				alert("Not Cancel");
				setTimeout("initRequest()",5000);
			}			
		}
	
	function postProcessdate(responseXML) {
		var employees = responseXML.getElementsByTagName("employees")[0];
		for (loop = 0; loop < employees.childNodes.length; loop++) {
			var employee = employees.childNodes[loop]
			var date = employee.getElementsByTagName("date")[0];
			var date1 = employee.getElementsByTagName("cdate")[0];
			appendEmployeedate(date.childNodes[0].nodeValue,date1.childNodes[0].nodeValue); 
		}
	}
	
	function appendEmployeedate(date,date1) {
		if(date!="null") {
			var status=confirm("\t\tonline negotitation\n\n\t\tWill you confortable to this offer\n\nStart date:"+date1+"\t"+"\tEnd date:"+date);
			if(status==true){
				var ajax1 = new AJAXInteractiondateconfirm("ajaxupdate1?date="+date+"&date1="+date1);
				
			}else{
				var ajax2 = new AJAXInteractiondateconfirm("ajaxupdate2?");				
			}			
		}
		else{
			setTimeout("initRequest()",5000);
		}
	}	
	