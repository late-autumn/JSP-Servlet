<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<hr>
  <%
     Cookie[] cookies =request.getCookies();
    
     if(cookies == null){
    	 out.println("쿠키가 없습니다.");
   
     }else {
    	 //쿠키가  있으면
    
    	 for(Cookie c: cookies){
    		 out.println("쿠키이름 :"+c.getName()+", ");
    		 out.println("쿠키 값 :"+c.getValue());
    	 }
      	 
     }
    
  
  %>

</body>
</html>