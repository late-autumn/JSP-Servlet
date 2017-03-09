<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="student" class ="Day04.javalec.Student" scope="page"/>

<hr>

<h3>폼에서 전달받아 저장</h3>

<jsp:setProperty property="*" name="student"/>

<hr>

 학생 ID : <jsp:getProperty property="id" name="student"/><br>
 학생 이름:<jsp:getProperty property="name" name="student"/><br>
 학생 번호 :<jsp:getProperty property="snum" name="student"/><br>
 나이(생년):<%=student.getAge() %>(<jsp:getProperty property="year" name="student"/>)<br>
 암호:<jsp:getProperty property="pass" name="student"/><br>
 이메일:<jsp:getProperty property="email" name="student"/><br>

</body>
</html>