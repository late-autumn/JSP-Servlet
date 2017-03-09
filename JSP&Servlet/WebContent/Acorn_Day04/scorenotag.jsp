<%@page import="javabean.ScoreBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<% javabean.ScoreBean score = new javabean.ScoreBean(); %>
<h3> 이름과 성적을 빈에 저장 </h3>

 <% score.setName("김유신"); %>
 <% score.setPoint(90); %>

  
<h3> 이름과 정보를 조회하여 출력 </h3>  

  이름 :  <% out.println(score.getName()); %><br>
  성적 :  <% out.println(score.getPoint()); %> 

</body>
</html>