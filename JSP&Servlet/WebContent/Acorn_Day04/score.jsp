<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="score" class="javabean.ScoreBean" scope="page" />  

<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<h2>JavaBeans 를 이용한 성적조회 프로그램 </h2>

<hr>
  <h3>이름과 성적을 JavaBeans ScoreBeans 에 저장</h3>
<%--   <p>
    이름 : <%="홍길동" %>
    성적 : <%="90" %>
  </p> --%>

   <p>  
   <jsp:setProperty property="name" name="score" value="홍길동"/>
   <jsp:setProperty property="point" name="score" value="90"/>
   </p>
   
   <hr>
   
   <h3>이름과 성적을 JavaBeans ScoreBeans 에 저장된 정보를 조회 </h3>
   
   이름 : <jsp:getProperty property="name" name="score"/>
   성적 : <jsp:getProperty property="point" name="score"/>
   
   </body>
</html>







