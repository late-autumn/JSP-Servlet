<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.sql.Connection" %>
<%@ page import ="javax.sql.DataSource" %>
<%@ page import ="javax.naming.InitialContext"%>
<%@ page import ="javax.naming.Context" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<h4>DBCP</h4>

<%
InitialContext context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/mydb");

Connection con= ds.getConnection();
out.println(con+"<br>");
out.println("디비 연동 성공");

%>

</body>
</html>