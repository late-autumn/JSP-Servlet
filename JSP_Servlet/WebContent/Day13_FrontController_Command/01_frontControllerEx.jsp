<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="insert.doing">insert</a>
	<hr />
 	<a href="http://localhost:9090<%=request.getContextPath()%>/update.doing">update</a>
	<hr />
	<a href="http://localhost:9090/day13_FrontController_Command/select.doing">select</a>
	<hr />
	<a href="<%=request.getContextPath()%>/delete.doing">delete</a>

</body>
</html>