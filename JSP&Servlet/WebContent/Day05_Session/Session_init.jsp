<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<%
	session.setAttribute("mySessionName","mySessionData");
	session.setAttribute("myNum", 12345);
%>

 <a href="Session_get.jsp">session get</a>

</body>
</html>