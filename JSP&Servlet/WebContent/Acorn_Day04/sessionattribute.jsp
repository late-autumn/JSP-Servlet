<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration, java.util.Date" %>    
    
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<h2> 세션 만들기 </h2>
<%
    session.setAttribute("id", "javajsp");
    session.setAttribute("pwd", "1234");
%>

<hr>
<h2> 세션 조회 </h2>

 세션 ID : <%=session.getId() %><br>
 세션 CreationTime() : <%= new Date(session.getCreationTime()) %><br><br>


<%

      Enumeration<String> e = session.getAttributeNames();
  //session.getAttributeNames() 메서드는 세션의 속성이름을 배열 형태로 갖고 있음
  
    while(e.hasMoreElements()){
    	
    	String name=e.nextElement();
    	String value=(String)session.getAttribute(name);
    	
    	out.println("세션 name :"+name+", ");
    	out.println("세션 value:"+value+"<br>");
       	
    }

%>

  <br> 세션 Invalidate <% session.invalidate(); %>
   <!-- 세션 종료 -->

</body>
</html>





