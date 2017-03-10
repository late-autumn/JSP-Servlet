<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	에러페이지 입니다.
	<br>
	<%= exception.getMessage() %>
</body>
</html>

<!-- 이 jsp는 xml 변경으로 인해 실행이 되진 않는다. -->