<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title> JSP 스크립트 </title>
</head>
<body>

<%
   String s ="스크립트 부분";
   String com ="주석처리 부분";
   out.println("내장객체를 이용하여 출력 :"+ declation +"<br><br>");

%>

선언문은 (변수) 출력 : <%=declation  %>
선언문은 (메서드) 출력 : <%=declationMe() %>



<%!  //변수 선언 부분

  String declation ="변수 선언";

%>

<%!
    //메서드 선언
    
    public String declationMe(){
	return declation;
	
}

%>





</body>
</html>