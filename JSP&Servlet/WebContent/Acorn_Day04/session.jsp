<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<h2>세션 정보 조회</h2>

세션 ID :<%=session.getId() %><br>
세션 MaxInactiveInterval(기본 세션 유지 시간):
  <%=session.getMaxInactiveInterval() %>

<%
  long mseconds = session.getCreationTime();

    Date time = new Date(mseconds);
 
%>

  세션 CreationTime(1970년 1월 1일 0시 이후의 지난 밀리세컨드):
    <%=mseconds %><br>
  세션 CreationTime(시간으로 다시 계산): <%=time.toLocaleString() %><br>   



</body>
</html>