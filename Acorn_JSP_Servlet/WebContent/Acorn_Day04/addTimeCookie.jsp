<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.Calendar" %>  
<!DOCTYPE html>
<html>
<head>

<title> 현재 시각을 쿠키로 저장</title>
</head>
<body>
  <h1>현재 시각을 쿠키로 저장</h1>
  
  <hr>
    
     Calendar day =Calendar.getInstance();<br>
     String now =day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1);<br>
     now += "-"+day.get(Calendar.DAY_OF_MONTH);<br>
     Cookie cookie = new Cookie("lastconnect", now);<br>     
     cookie.setMaxAge(10);// 10초
     response.addCookie(cookie);<br>
   
    <%
    Calendar day =Calendar.getInstance();
    String now =day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1);
    now += "-"+day.get(Calendar.DAY_OF_MONTH);
    Cookie cookie = new Cookie("lastconnect", now);     
    cookie.setMaxAge(10);// 10초
    response.addCookie(cookie);
 
    %>  
  
    <hr>
      <a href="getcookies.jsp">쿠키조회</a>
    </body>
</html>