<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration, java.util.Date" %>
    
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>
<hr>
<h2>세션 만들기</h2>

<%! long beforetime = new Date().getTime(); %>
 <!-- 이전 페이지 참조 시간을 저장하는 변수 선언 -->

<%
    long nowtime = new Date().getTime();
  
     if(session.isNew()){
    	 
    	 session.setAttribute("id", session.getId());
    	 session.setAttribute("time", new Date(session.getCreationTime()));
    	 session.setMaxInactiveInterval(5);
    	 
     }else {
    	 session.removeAttribute("id");
     }

%>

 <hr>
 <h2>세션 조회</h2>
 
   세션 ID(유일한 식별자) :<%=session.getAttribute("id") %>
   세션 CreationTime : <%=session.getAttribute("time") %>
   세션 MaxInactiveInterval : <%=session.getMaxInactiveInterval() %>

    <% long sessiontime = nowtime-session.getCreationTime(); %>

    세션이 만들어진 이후 지난 시간 : <%=sessiontime/1000 %>초
    
    <font color=blue><hr>
    <% long inactiveinterval = nowtime - beforetime; %>
    
    서버에 반응을 보이지 않은 시간 : <%=inactiveinterval/1000 %>초 <br>
    
    위 시간이 <%=session.getMaxInactiveInterval() %>초를 지나면
    이전 세션이 무효화되고 새로운 세션이 생성
       
    </font><br>

    <% beforetime = nowtime; %>

</body>
</html>