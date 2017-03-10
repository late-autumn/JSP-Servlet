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
	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		String sName = enumeration.nextElement().toString();
		String sNum = (String)session.getAttribute(sName);
		if(sNum.equals("abcd"))
		out.println("welcome");
	}
%>
<a href ="logout.jsp">로그아웃</a>

</body>
</html>