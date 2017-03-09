<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${ 1+2 } <br />
	${ 1-2 } <br />
	${ 1*2 } <br />
	${ 1/2 } <br />
	${ 1>2 } <br />
	${ 1<2 } <br />
	${ (1>2) ? 1 : 2 } <br />
	${ (1>2) || (1<2) } <br />
	
	<hr/>
	
	<%= 1+2 %><br/>
	<%= 1-2 %> <br />
	<%= 1*2 %><br />
	<%= 1/2 %> <br />
	<%= 1>2 %> <br />
	<%= 1<2 %> <br />
	<%= (1>2) ? 1 : 2 %> <br />
	<%= (1>2) || (1<2) %> <br />
	
	
</body>
</html>