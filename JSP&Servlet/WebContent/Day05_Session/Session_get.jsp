<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<%
	Object ob1 = session.getAttribute("mySessionName");
	String mySessionName = (String)ob1;
	out.println(mySessionName+"<br>");
	
 	Object ob2 = session.getAttribute("myNum");
	Integer myNum = (Integer)ob2;
	out.println(myNum+"<br>"); 
	
	out.println("===========================<br>");
	
	String sName, sNum;
	
	Enumeration enumberation = session.getAttributeNames();
	while(enumberation.hasMoreElements()){
		sName = enumberation.nextElement().toString();
		sNum = session.getAttribute(sName).toString();
		out.println("sName:"+sName+"<br>");
		out.println("sNum:"+sNum+"<br>");
		out.println("<br>");
		
	}
	out.println("=========================<br>");
	
	session.removeAttribute("mySessionName");		//removeAttribute로 특정 세션 삭제
	//session.removeAttribute("myNum");
	Enumeration enumberation1 = session.getAttributeNames();
	while(enumberation1.hasMoreElements()){
		sName = enumberation1.nextElement().toString();
		sNum = session.getAttribute(sName).toString();
		out.println("sName:"+sName+"<br>");
		out.println("sNum:"+sNum+"<br>");
		out.println("<br>");
	}
	out.println("=========================<br>");


%>

</body>
</html>