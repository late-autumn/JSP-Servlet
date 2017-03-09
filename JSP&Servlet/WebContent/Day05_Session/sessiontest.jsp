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
	Enumeration enumberation = session.getAttributeNames();
	int i=0;
	while(enumberation.hasMoreElements()){
		i++;
	
	String sName = enumberation.nextElement().toString();
	String sNum = (String)session.getAttribute(sName);
	out.println("sName:"+sName+"<br>");
	out.println("sNum:"+sNum+"<br>");
	out.println("<br>");
	}
	if(i==0) out.println("해당 세션이 삭제되었습니다.");
	
%>

</body>
</html>