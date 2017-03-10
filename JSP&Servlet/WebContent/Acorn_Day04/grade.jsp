<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<h2> JavaBeans 를 이용한 학생의 점수에 따른 성적 처리 </h2>

 <% request.setCharacterEncoding("utf-8"); %>

	<jsp:useBean id="score" class="javabean.GradeBean" scope="page" />

  <hr>

  <h3> 폼에서 전달받은 이름과 성적을 GradeBean에 저장</h3>

    이름 :<%=request.getParameter("name") %> 
    성적 :<%=request.getParameter("point") %>

    <jsp:setProperty property="name" name="score" param="name"/>
    <jsp:setProperty property="point" name="score" param="point"/>

   <hr>
   <h3> JavaBean GradeBean 에 저장된 정보를 조회 출력 </h3>
   
    이름 : <jsp:getProperty property="name" name="score"/>
    성적 : <jsp:getProperty property="point" name="score"/>
    등급 : <jsp:getProperty property="grade" name="score"/>

</body>
</html>