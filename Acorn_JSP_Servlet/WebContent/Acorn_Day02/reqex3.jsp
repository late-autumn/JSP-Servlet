<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Enumeration" %> 
   
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<%
    Enumeration enumData = request.getHeaderNames();
    //모든 헤더의 이름을 얻어옴
    
    while(enumData.hasMoreElements()){
    	String headerName=(String)enumData.nextElement();
    	String headerValue=request.getHeader(headerName);
    
   %>
   <%=headerName %> =<%=headerValue %>  <br><br>	
    	
   <% 	
    }
    %>

</body>
</html>