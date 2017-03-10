<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

  <h1> Cookie </h1>

   <hr>
  Cookie cookie = new Cookie("user", "park");<br>
  cookie.setMaxage(2*60); 
  response.addCookie(cookie);<br>
  
  <%
     Cookie cookie = new Cookie("user", "hong");
     // 쿠키 객치 생성
     cookie.setMaxAge(2*60);//초단위 (분) 약2분
     //쿠키의 유효시간 설정 
     //(음수로 지정하면 브라우저가 종료될때 쿠키도 함께 삭제됨)
     response.addCookie(cookie);
     //addCookie 메서드를 이용하여 클라이언트의 컴퓨터에 파일 형태로 저장
  
  %>    
    
   <hr>
     <a href="addTimeCookie.jsp">현재 접속 시각을 쿠키로 추가</a>
   
   </body>
</html>