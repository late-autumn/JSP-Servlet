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
	Enumeration enumberation2 = session.getAttributeNames();
	while(enumberation2.hasMoreElements()){
	String sName = enumberation2.nextElement().toString();
	String sNum = (String)session.getAttribute(sName);
	
	if(sNum.equals("abcd")){
		session.removeAttribute(sName);
	}
	}


%>

<a href ="sessiontest.jsp">session Test</a>

</body>
</html>