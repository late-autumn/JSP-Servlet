<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
   String name = request.getParameter("name");
   String subject = request.getParameter("subject");
   String filename1 = request.getParameter("filename1");
   String filename2 = request.getParameter("filename2");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
   올린 사람:<%=name%>
   <br> 제목:<%=subject%>
   <br> 파일명1:
   <a href="upload/<%=filename1%>"></a>
   <br>
   <img src="upload/<%=filename1%>" border=0 width="100" height="100"> 파일명2:
   <a href="upload/<%=filename2%>"></a>
   <br>
   <img src="upload/<%=filename1%>" border=0 width="100" height="100">
</body>
</html>