<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder, java.net.URLDecoder" %>    
    
<!DOCTYPE html>
<html>
<head>

<title> </title>
</head>
<body>

<h2>쿠키 한글 입력시 인코딩 처리 삽입, 그대로 출력</h2>

 <%
  Cookie user = new Cookie("username", 
		  URLEncoder.encode("홍길동", "UTF-8"));

  Cookie pass = new Cookie("password", 
		URLEncoder.encode("hong1234", "UTF-8"));

   response.addCookie(user);
   response.addCookie(pass);
   
   Cookie[] cs = request.getCookies();
   
   if(cs !=null){
	   
	   for(Cookie cook : cs){
		   out.println(cook.getName()+" :");
		   out.println(cook.getValue()+"<br>");
	 
	   }
    }
  %>

<h2> 쿠키 한글로 디코딩하여 출력  </h2>
   <%
   
    if(cs != null){
    	
    	for(Cookie cook : cs){
    		
    		out.println(cook.getName() +":");
    		out.println(URLDecoder.decode(cook.getValue(), "UTF-8")+"<br>");
      		
    	}
     	
    }
   
  %>

</body>
</html>